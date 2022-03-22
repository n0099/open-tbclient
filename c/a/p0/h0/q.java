package c.a.p0.h0;

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
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class q implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f15374b;

    /* renamed from: c  reason: collision with root package name */
    public View f15375c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f15376d;

    /* renamed from: e  reason: collision with root package name */
    public View f15377e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f15378f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f15379g;

    /* renamed from: h  reason: collision with root package name */
    public int f15380h;
    public String i;

    public q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15380h = 3;
        this.a = context;
        c(context);
    }

    public ImageView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15379g : (ImageView) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15374b : (View) invokeV.objValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01aa, (ViewGroup) null);
            this.f15374b = inflate;
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f091aee);
            this.f15375c = findViewById;
            findViewById.setOnClickListener(this);
            this.f15376d = (ImageView) this.f15374b.findViewById(R.id.obfuscated_res_0x7f090eda);
            this.f15377e = this.f15374b.findViewById(R.id.obfuscated_res_0x7f0923d6);
            this.f15378f = (EMTextView) this.f15374b.findViewById(R.id.obfuscated_res_0x7f09203e);
            ImageView imageView = (ImageView) this.f15374b.findViewById(R.id.obfuscated_res_0x7f090662);
            this.f15379g = imageView;
            imageView.setClickable(true);
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || StringUtils.isNull(TbSingleton.getInstance().getBannerText())) {
            return;
        }
        this.f15378f.setText(TbSingleton.getInstance().getBannerText());
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (this.f15380h != i) {
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f15375c);
                d2.n(R.string.J_X06);
                d2.f(R.color.CAM_X0201);
                c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.f15377e);
                d3.n(R.string.J_X03);
                d3.f(R.color.CAM_X0110);
                c.a.o0.r.v.c.d(this.f15378f).v(R.color.CAM_X0108);
                this.f15379g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_close22, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
                if (i == 4) {
                    WebPManager.setMaskDrawable(this.f15376d, R.drawable.obfuscated_res_0x7f080f5e, WebPManager.ResourceStateType.NORMAL);
                } else if (i == 1) {
                    WebPManager.setMaskDrawable(this.f15376d, R.drawable.obfuscated_res_0x7f080f5d, WebPManager.ResourceStateType.NORMAL);
                } else {
                    WebPManager.setMaskDrawable(this.f15376d, R.drawable.obfuscated_res_0x7f080f5c, WebPManager.ResourceStateType.NORMAL);
                }
            }
            this.f15380h = i;
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if ("2".equals(str)) {
                c.a.p0.q1.h.h.a.a("c14079", "0", str);
            }
            if ("1".equals(str)) {
                c.a.p0.q1.h.h.a.a("c14079", StringUtils.isNull(TbSingleton.getInstance().getLFUserTaskId()) ? "0" : TbSingleton.getInstance().getLFUserTaskId(), str);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            HashMap hashMap = new HashMap();
            if ("from_personaize".equals(this.i)) {
                hashMap.put(LowFlowsActivityConfig.LF_USER, TbSingleton.getInstance().getLFUser());
                hashMap.put(LowFlowsActivityConfig.LF_USER_TASKID, TbSingleton.getInstance().getLFUserTaskId());
                c.a.p0.q1.h.h.a.a("c14080", StringUtils.isNull(TbSingleton.getInstance().getLFUserTaskId()) ? "0" : TbSingleton.getInstance().getLFUserTaskId(), "1");
            } else {
                hashMap.put(LowFlowsActivityConfig.LF_USER, "1");
                c.a.p0.q1.h.h.a.a("c14080", "0", "2");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a, "TreasureTrovePage", hashMap)));
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.i = str;
        }
    }
}
