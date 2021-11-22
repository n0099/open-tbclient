package b.a.r0.b0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class r implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f16330e;

    /* renamed from: f  reason: collision with root package name */
    public View f16331f;

    /* renamed from: g  reason: collision with root package name */
    public View f16332g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f16333h;

    /* renamed from: i  reason: collision with root package name */
    public View f16334i;
    public EMTextView j;
    public ImageView k;
    public int l;
    public String m;

    public r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 3;
        this.f16330e = context;
        c(context);
    }

    public ImageView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (ImageView) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16331f : (View) invokeV.objValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_low_flows_view, (ViewGroup) null);
            this.f16331f = inflate;
            View findViewById = inflate.findViewById(R.id.root_view);
            this.f16332g = findViewById;
            findViewById.setOnClickListener(this);
            this.f16333h = (ImageView) this.f16331f.findViewById(R.id.img_tb_storehouse);
            this.f16334i = this.f16331f.findViewById(R.id.view_point);
            this.j = (EMTextView) this.f16331f.findViewById(R.id.title_content);
            ImageView imageView = (ImageView) this.f16331f.findViewById(R.id.close);
            this.k = imageView;
            imageView.setClickable(true);
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || StringUtils.isNull(TbSingleton.getInstance().getBannerText())) {
            return;
        }
        this.j.setText(TbSingleton.getInstance().getBannerText());
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (this.l != i2) {
                b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f16332g);
                d2.n(R.string.J_X06);
                d2.f(R.color.CAM_X0201);
                b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.f16334i);
                d3.n(R.string.J_X03);
                d3.f(R.color.CAM_X0110);
                b.a.q0.s.u.c.d(this.j).v(R.color.CAM_X0108);
                this.k.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_close22, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
                if (i2 == 4) {
                    WebPManager.setMaskDrawable(this.f16333h, R.drawable.pic_tiebatreasure_28_2, WebPManager.ResourceStateType.NORMAL);
                } else if (i2 == 1) {
                    WebPManager.setMaskDrawable(this.f16333h, R.drawable.pic_tiebatreasure_28_1, WebPManager.ResourceStateType.NORMAL);
                } else {
                    WebPManager.setMaskDrawable(this.f16333h, R.drawable.pic_tiebatreasure_28, WebPManager.ResourceStateType.NORMAL);
                }
            }
            this.l = i2;
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if ("2".equals(str)) {
                b.a.r0.h1.g.h.a.a("c14079", "0", str);
            }
            if ("1".equals(str)) {
                b.a.r0.h1.g.h.a.a("c14079", StringUtils.isNull(TbSingleton.getInstance().getLFUserTaskId()) ? "0" : TbSingleton.getInstance().getLFUserTaskId(), str);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            HashMap hashMap = new HashMap();
            if ("from_personaize".equals(this.m)) {
                hashMap.put(LowFlowsActivityConfig.LF_USER, TbSingleton.getInstance().getLFUser());
                hashMap.put(LowFlowsActivityConfig.LF_USER_TASKID, TbSingleton.getInstance().getLFUserTaskId());
                b.a.r0.h1.g.h.a.a("c14080", StringUtils.isNull(TbSingleton.getInstance().getLFUserTaskId()) ? "0" : TbSingleton.getInstance().getLFUserTaskId(), "1");
            } else {
                hashMap.put(LowFlowsActivityConfig.LF_USER, "1");
                b.a.r0.h1.g.h.a.a("c14080", "0", "2");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new b.a.r0.m3.j0.n(this.f16330e, "TreasureTrovePage", hashMap)));
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.m = str;
        }
    }
}
