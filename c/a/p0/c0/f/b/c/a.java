package c.a.p0.c0.f.b.c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public Context f12888b;

    /* renamed from: c  reason: collision with root package name */
    public View f12889c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f12890d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f12891e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f12892f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12893g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12894h;
    public LinearLayout i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public View m;
    public LinearLayout n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public View r;
    public View s;
    public List<FunctionListInfo> t;

    /* renamed from: c.a.p0.c0.f.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0970a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunctionListInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f12895b;

        public View$OnClickListenerC0970a(a aVar, FunctionListInfo functionListInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, functionListInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12895b = aVar;
            this.a = functionListInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f12895b.k(1, this.a.url);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.f12888b);
                    return;
                }
                a aVar = this.a;
                aVar.n("prefer_key_history", aVar.m);
                this.a.f12888b.startActivity(new Intent(this.a.f12888b, AlaRecentHistoryActivity.class));
                TiebaStatic.log("c12648");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunctionListInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f12896b;

        public c(a aVar, FunctionListInfo functionListInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, functionListInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12896b = aVar;
            this.a = functionListInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f12896b.k(3, this.a.url);
                a aVar = this.f12896b;
                aVar.n("prefer_key_activity", aVar.r);
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f12888b = tbPageContext.getPageActivity();
        j();
    }

    public void f(List<FunctionListInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.t = list;
            for (FunctionListInfo functionListInfo : list) {
                if (functionListInfo != null) {
                    int intValue = functionListInfo.id.intValue();
                    if (intValue == 1) {
                        this.f12891e.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.f12893g.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.f12894h.setVisibility(0);
                            this.f12894h.setText(functionListInfo.describe);
                        }
                        this.f12891e.setOnClickListener(new View$OnClickListenerC0970a(this, functionListInfo));
                    } else if (intValue == 2) {
                        this.i.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.k.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.l.setVisibility(0);
                            this.l.setText(functionListInfo.describe);
                        }
                        i(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.m);
                        this.i.setOnClickListener(new b(this));
                    } else if (intValue == 3) {
                        this.n.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.p.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.q.setVisibility(0);
                            this.q.setText(functionListInfo.describe);
                        }
                        i(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.r);
                        this.n.setOnClickListener(new c(this, functionListInfo));
                    }
                }
            }
            TiebaStatic.log("c12647");
        }
    }

    public final long g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? c.a.o0.r.j0.b.k().m(str, 0L) : invokeL.longValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12889c : (View) invokeV.objValue;
    }

    public final void i(int i, long j, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), view}) == null) {
            if (g(i != 2 ? i != 3 ? null : "prefer_key_activity" : "prefer_key_history") < j) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(this.f12888b).inflate(R.layout.obfuscated_res_0x7f0d07a7, (ViewGroup) null);
            this.f12889c = inflate;
            this.f12890d = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091d72);
            LinearLayout linearLayout = (LinearLayout) this.f12889c.findViewById(R.id.obfuscated_res_0x7f091d78);
            this.f12891e = linearLayout;
            linearLayout.setVisibility(8);
            this.f12892f = (ImageView) this.f12889c.findViewById(R.id.obfuscated_res_0x7f091d7a);
            this.f12893g = (TextView) this.f12889c.findViewById(R.id.obfuscated_res_0x7f091d7b);
            this.f12894h = (TextView) this.f12889c.findViewById(R.id.obfuscated_res_0x7f091d79);
            LinearLayout linearLayout2 = (LinearLayout) this.f12889c.findViewById(R.id.obfuscated_res_0x7f091d73);
            this.i = linearLayout2;
            linearLayout2.setVisibility(8);
            this.j = (ImageView) this.f12889c.findViewById(R.id.obfuscated_res_0x7f091d75);
            this.k = (TextView) this.f12889c.findViewById(R.id.obfuscated_res_0x7f091d77);
            this.l = (TextView) this.f12889c.findViewById(R.id.obfuscated_res_0x7f091d74);
            this.m = this.f12889c.findViewById(R.id.obfuscated_res_0x7f091d76);
            LinearLayout linearLayout3 = (LinearLayout) this.f12889c.findViewById(R.id.obfuscated_res_0x7f091d6c);
            this.n = linearLayout3;
            linearLayout3.setVisibility(8);
            this.o = (ImageView) this.f12889c.findViewById(R.id.obfuscated_res_0x7f091d6e);
            this.p = (TextView) this.f12889c.findViewById(R.id.obfuscated_res_0x7f091d70);
            this.q = (TextView) this.f12889c.findViewById(R.id.obfuscated_res_0x7f091d6d);
            this.r = this.f12889c.findViewById(R.id.obfuscated_res_0x7f091d6f);
            this.s = this.f12889c.findViewById(R.id.obfuscated_res_0x7f091d71);
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void k(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
            TiebaStatic.log(new StatisticItem("c12215"));
            c.a.o0.l.a.m(this.f12888b, str);
            if (3 == i) {
                TiebaStatic.log("c12649");
            } else if (1 == i) {
                TiebaStatic.log("c12215");
            }
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setBackgroundResource(this.f12890d, R.color.CAM_X0201);
        SkinManager.setImageResource(this.f12892f, R.drawable.live_portal_rank);
        SkinManager.setViewTextColor(this.f12893g, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f12894h, (int) R.color.CAM_X0109);
        SkinManager.setImageResource(this.j, R.drawable.live_import_history);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        SkinManager.setImageResource(this.o, R.drawable.live_import_activity);
        SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.s, R.color.CAM_X0205);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public final void n(String str, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, view) == null) {
            c.a.o0.r.j0.b.k().x(str, System.currentTimeMillis() / 1000);
            view.setVisibility(8);
        }
    }
}
