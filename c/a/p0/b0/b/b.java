package c.a.p0.b0.b;

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
import c.a.o0.a.h;
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
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PopupWindow f12419b;

        public a(h hVar, PopupWindow popupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, popupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
            this.f12419b = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.obfuscated_res_0x7f090cc0) {
                    if (c.a.d.a.b.g().b() != null && !StringUtils.isNull(this.a.f())) {
                        Uri parse = Uri.parse(this.a.f());
                        if (parse != null && parse.getQueryParameters("obj_type") != null && parse.getQueryParameters("obj_source") != null) {
                            TiebaStatic.log(new StatisticItem("c13391").param("obj_type", parse.getQueryParameter("obj_type")).param("obj_source", parse.getQueryParameter("obj_source")));
                        }
                        if (this.a.f().startsWith(BdUniDispatchSchemeController.SCHEME)) {
                            Uri.Builder buildUpon = Uri.parse(this.a.f()).buildUpon();
                            buildUpon.appendQueryParameter(BdUniDispatchSchemeController.PARAM_SCHEME_FROM, BdUniDispatchSchemeController.SCHEME_FROM_TB_TOKEN);
                            parse = buildUpon.build();
                        }
                        UtilHelper.dealOneScheme(c.a.d.a.b.g().b(), parse.toString());
                    }
                    try {
                        this.f12419b.dismiss();
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                } else if (view.getId() == R.id.obfuscated_res_0x7f090cbf) {
                    try {
                        this.f12419b.dismiss();
                    } catch (Throwable th2) {
                        BdLog.e(th2);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.p0.b0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class View$OnClickListenerC0927b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f12420b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PopupWindow f12421c;

        public View$OnClickListenerC0927b(String str, h hVar, PopupWindow popupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, hVar, popupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f12420b = hVar;
            this.f12421c = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.obfuscated_res_0x7f090cc0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921361, this.a));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", this.f12420b.j).param("obj_source", "tb_password").param("obj_name", this.f12420b.f9680h).param("obj_param1", this.f12420b.k.intValue()));
                    try {
                        this.f12421c.dismiss();
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                } else if (view.getId() == R.id.obfuscated_res_0x7f090cbf) {
                    try {
                        this.f12421c.dismiss();
                    } catch (Throwable th2) {
                        BdLog.e(th2);
                    }
                }
            }
        }
    }

    public static PopupWindow a(h hVar) {
        InterceptResult invokeL;
        View.OnClickListener aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hVar)) == null) {
            Activity b2 = c.a.d.a.b.g().b();
            if (b2 == null || hVar == null) {
                return null;
            }
            String f2 = hVar.f();
            if (StringUtils.isNull(f2)) {
                return null;
            }
            View inflate = LayoutInflater.from(b2).inflate(R.layout.obfuscated_res_0x7f0d00de, (ViewGroup) null, true);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090cc0);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090cbf);
            TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092096);
            TextView textView4 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092095);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092097);
            tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f0811da);
            tbImageView.setAutoChangeStyle(false);
            PopupWindow popupWindow = new PopupWindow(b2);
            if (hVar.g() != 3) {
                aVar = new View$OnClickListenerC0927b(f2, hVar, popupWindow);
                if (!StringUtils.isNull(hVar.c())) {
                    tbImageView.J(hVar.c(), 10, false);
                } else {
                    tbImageView.setImageResource(R.drawable.obfuscated_res_0x7f0811da);
                }
            } else {
                tbImageView.setImageResource(R.drawable.obfuscated_res_0x7f0811db);
                aVar = new a(hVar, popupWindow);
            }
            textView.setOnClickListener(aVar);
            textView2.setOnClickListener(aVar);
            textView.setText(hVar.b());
            textView2.setText(hVar.a());
            textView3.setText(hVar.e());
            textView4.setText(hVar.d());
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
