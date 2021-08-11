package c.a.p0.u.b;

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
import c.a.e.e.p.l;
import c.a.o0.a.g;
import c.a.o0.a.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.u.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class View$OnClickListenerC1134a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f24434e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PopupWindow f24435f;

        public View$OnClickListenerC1134a(h hVar, PopupWindow popupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, popupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24434e = hVar;
            this.f24435f = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.go_to_aiapps_go) {
                    if (c.a.e.a.b.f().b() != null && !StringUtils.isNull(this.f24434e.f())) {
                        Uri parse = Uri.parse(this.f24434e.f());
                        if (parse != null && parse.getQueryParameters("obj_type") != null && parse.getQueryParameters("obj_source") != null) {
                            TiebaStatic.log(new StatisticItem("c13391").param("obj_type", parse.getQueryParameter("obj_type")).param("obj_source", parse.getQueryParameter("obj_source")));
                        }
                        if (this.f24434e.f().startsWith(g.f12331a)) {
                            Uri.Builder buildUpon = Uri.parse(this.f24434e.f()).buildUpon();
                            buildUpon.appendQueryParameter(g.x, g.U);
                            parse = buildUpon.build();
                        }
                        UtilHelper.dealOneScheme(c.a.e.a.b.f().b(), parse.toString());
                    }
                    try {
                        this.f24435f.dismiss();
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                } else if (view.getId() == R.id.go_to_aiapps_cancel) {
                    try {
                        this.f24435f.dismiss();
                    } catch (Throwable th2) {
                        BdLog.e(th2);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f24436e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f24437f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PopupWindow f24438g;

        public b(String str, h hVar, PopupWindow popupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, hVar, popupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24436e = str;
            this.f24437f = hVar;
            this.f24438g = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.go_to_aiapps_go) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921361, this.f24436e));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", this.f24437f.f12351j).param("obj_source", "tb_password").param("obj_name", this.f24437f.f12349h).param("obj_param1", this.f24437f.k.intValue()));
                    try {
                        this.f24438g.dismiss();
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                } else if (view.getId() == R.id.go_to_aiapps_cancel) {
                    try {
                        this.f24438g.dismiss();
                    } catch (Throwable th2) {
                        BdLog.e(th2);
                    }
                }
            }
        }
    }

    public static PopupWindow a(h hVar) {
        InterceptResult invokeL;
        View.OnClickListener view$OnClickListenerC1134a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hVar)) == null) {
            Activity b2 = c.a.e.a.b.f().b();
            if (b2 == null || hVar == null) {
                return null;
            }
            String f2 = hVar.f();
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
            if (hVar.g() != 3) {
                view$OnClickListenerC1134a = new b(f2, hVar, popupWindow);
                if (!StringUtils.isNull(hVar.c())) {
                    tbImageView.startLoad(hVar.c(), 10, false);
                } else {
                    tbImageView.setImageResource(R.drawable.toastpic);
                }
            } else {
                tbImageView.setImageResource(R.drawable.toastpic_scheme);
                view$OnClickListenerC1134a = new View$OnClickListenerC1134a(hVar, popupWindow);
            }
            textView.setOnClickListener(view$OnClickListenerC1134a);
            textView2.setOnClickListener(view$OnClickListenerC1134a);
            textView.setText(hVar.b());
            textView2.setText(hVar.a());
            textView3.setText(hVar.e());
            textView4.setText(hVar.d());
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setColor(Color.argb(178, 0, 0, 0));
            popupWindow.setBackgroundDrawable(colorDrawable);
            popupWindow.setWidth(l.k(b2));
            popupWindow.setHeight(l.i(b2));
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
