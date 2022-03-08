package c.a.r0.z.b;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.q0.a.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f25243e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PopupWindow f25244f;

        public a(g gVar, PopupWindow popupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, popupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25243e = gVar;
            this.f25244f = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.go_to_aiapps_go) {
                    if (c.a.d.a.b.g().b() != null && !StringUtils.isNull(this.f25243e.f())) {
                        Uri parse = Uri.parse(this.f25243e.f());
                        if (parse != null && parse.getQueryParameters("obj_type") != null && parse.getQueryParameters("obj_source") != null) {
                            TiebaStatic.log(new StatisticItem("c13391").param("obj_type", parse.getQueryParameter("obj_type")).param("obj_source", parse.getQueryParameter("obj_source")));
                        }
                        if (this.f25243e.f().startsWith(BdUniDispatchSchemeController.SCHEME)) {
                            Uri.Builder buildUpon = Uri.parse(this.f25243e.f()).buildUpon();
                            buildUpon.appendQueryParameter(BdUniDispatchSchemeController.PARAM_SCHEME_FROM, BdUniDispatchSchemeController.SCHEME_FROM_TB_TOKEN);
                            parse = buildUpon.build();
                        }
                        UtilHelper.dealOneScheme(c.a.d.a.b.g().b(), parse.toString());
                    }
                    try {
                        this.f25244f.dismiss();
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                } else if (view.getId() == R.id.go_to_aiapps_cancel) {
                    try {
                        this.f25244f.dismiss();
                    } catch (Throwable th2) {
                        BdLog.e(th2);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.r0.z.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class View$OnClickListenerC1537b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f25245e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f25246f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PopupWindow f25247g;

        public View$OnClickListenerC1537b(String str, g gVar, PopupWindow popupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, gVar, popupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25245e = str;
            this.f25246f = gVar;
            this.f25247g = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.go_to_aiapps_go) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921361, this.f25245e));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", this.f25246f.f11873j).param("obj_source", "tb_password").param("obj_name", this.f25246f.f11871h).param("obj_param1", this.f25246f.k.intValue()));
                    try {
                        this.f25247g.dismiss();
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                } else if (view.getId() == R.id.go_to_aiapps_cancel) {
                    try {
                        this.f25247g.dismiss();
                    } catch (Throwable th2) {
                        BdLog.e(th2);
                    }
                }
            }
        }
    }

    public static PopupWindow a(g gVar) {
        InterceptResult invokeL;
        View.OnClickListener aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gVar)) == null) {
            Activity b2 = c.a.d.a.b.g().b();
            if (b2 == null || gVar == null) {
                return null;
            }
            String f2 = gVar.f();
            if (StringUtils.isNull(f2)) {
                return null;
            }
            View inflate = LayoutInflater.from(b2).inflate(R.layout.aiapps_token_layout, (ViewGroup) null, true);
            TextView textView = (TextView) inflate.findViewById(R.id.go_to_aiapps_go);
            TextView textView2 = (TextView) inflate.findViewById(R.id.go_to_aiapps_cancel);
            TextView textView3 = (TextView) inflate.findViewById(R.id.token_title);
            TextView textView4 = (TextView) inflate.findViewById(R.id.token_tip);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.token_top_cover);
            tbImageView.setDefaultResource(R.drawable.toastpic);
            tbImageView.setAutoChangeStyle(false);
            PopupWindow popupWindow = new PopupWindow(b2);
            if (gVar.g() != 3) {
                aVar = new View$OnClickListenerC1537b(f2, gVar, popupWindow);
                if (!StringUtils.isNull(gVar.c())) {
                    tbImageView.startLoad(gVar.c(), 10, false);
                } else {
                    tbImageView.setImageResource(R.drawable.toastpic);
                }
            } else {
                tbImageView.setImageResource(R.drawable.toastpic_scheme);
                aVar = new a(gVar, popupWindow);
            }
            textView.setOnClickListener(aVar);
            textView2.setOnClickListener(aVar);
            textView.setText(gVar.b());
            textView2.setText(gVar.a());
            textView3.setText(gVar.e());
            textView4.setText(gVar.d());
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setColor(Color.argb(178, 0, 0, 0));
            popupWindow.setBackgroundDrawable(colorDrawable);
            popupWindow.setWidth(n.k(b2));
            popupWindow.setHeight(n.i(b2));
            popupWindow.setContentView(inflate);
            popupWindow.setOutsideTouchable(true);
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mLayoutInScreen");
                    declaredField.setAccessible(true);
                    declaredField.set(popupWindow, Boolean.TRUE);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (NoSuchFieldException e3) {
                    e3.printStackTrace();
                }
            }
            return popupWindow;
        }
        return (PopupWindow) invokeL.objValue;
    }
}
