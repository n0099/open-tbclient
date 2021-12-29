package c.a.t0.a0.f.b.c;

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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public Context f14724b;

    /* renamed from: c  reason: collision with root package name */
    public View f14725c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f14726d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f14727e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f14728f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14729g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f14730h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f14731i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f14732j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f14733k;
    public TextView l;
    public View m;
    public LinearLayout n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public View r;
    public View s;
    public List<FunctionListInfo> t;

    /* renamed from: c.a.t0.a0.f.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0903a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FunctionListInfo f14734e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f14735f;

        public View$OnClickListenerC0903a(a aVar, FunctionListInfo functionListInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, functionListInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14735f = aVar;
            this.f14734e = functionListInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14735f.k(1, this.f14734e.url);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14736e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14736e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.f14736e.f14724b);
                    return;
                }
                a aVar = this.f14736e;
                aVar.n("prefer_key_history", aVar.m);
                this.f14736e.f14724b.startActivity(new Intent(this.f14736e.f14724b, AlaRecentHistoryActivity.class));
                TiebaStatic.log("c12648");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FunctionListInfo f14737e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f14738f;

        public c(a aVar, FunctionListInfo functionListInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, functionListInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14738f = aVar;
            this.f14737e = functionListInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14738f.k(3, this.f14737e.url);
                a aVar = this.f14738f;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f14724b = tbPageContext.getPageActivity();
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
                        this.f14727e.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.f14729g.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.f14730h.setVisibility(0);
                            this.f14730h.setText(functionListInfo.describe);
                        }
                        this.f14727e.setOnClickListener(new View$OnClickListenerC0903a(this, functionListInfo));
                    } else if (intValue == 2) {
                        this.f14731i.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.f14733k.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.l.setVisibility(0);
                            this.l.setText(functionListInfo.describe);
                        }
                        i(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.m);
                        this.f14731i.setOnClickListener(new b(this));
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
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? c.a.s0.s.g0.b.j().l(str, 0L) : invokeL.longValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14725c : (View) invokeV.objValue;
    }

    public final void i(int i2, long j2, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), view}) == null) {
            if (g(i2 != 2 ? i2 != 3 ? null : "prefer_key_activity" : "prefer_key_history") < j2) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(this.f14724b).inflate(R.layout.square_live_function_region_layout, (ViewGroup) null);
            this.f14725c = inflate;
            this.f14726d = (LinearLayout) inflate.findViewById(R.id.square_function_container);
            LinearLayout linearLayout = (LinearLayout) this.f14725c.findViewById(R.id.square_function_rank);
            this.f14727e = linearLayout;
            linearLayout.setVisibility(8);
            this.f14728f = (ImageView) this.f14725c.findViewById(R.id.square_function_rank_img);
            this.f14729g = (TextView) this.f14725c.findViewById(R.id.square_function_rank_title);
            this.f14730h = (TextView) this.f14725c.findViewById(R.id.square_function_rank_desc);
            LinearLayout linearLayout2 = (LinearLayout) this.f14725c.findViewById(R.id.square_function_history);
            this.f14731i = linearLayout2;
            linearLayout2.setVisibility(8);
            this.f14732j = (ImageView) this.f14725c.findViewById(R.id.square_function_history_img);
            this.f14733k = (TextView) this.f14725c.findViewById(R.id.square_function_history_title);
            this.l = (TextView) this.f14725c.findViewById(R.id.square_function_history_desc);
            this.m = this.f14725c.findViewById(R.id.square_function_history_red_pointer);
            LinearLayout linearLayout3 = (LinearLayout) this.f14725c.findViewById(R.id.square_function_activity);
            this.n = linearLayout3;
            linearLayout3.setVisibility(8);
            this.o = (ImageView) this.f14725c.findViewById(R.id.square_function_activity_img);
            this.p = (TextView) this.f14725c.findViewById(R.id.square_function_activity_title);
            this.q = (TextView) this.f14725c.findViewById(R.id.square_function_activity_desc);
            this.r = this.f14725c.findViewById(R.id.square_function_activity_red_pointer);
            this.s = this.f14725c.findViewById(R.id.square_function_bottom_space);
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void k(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
            TiebaStatic.log(new StatisticItem("c12215"));
            c.a.s0.m.a.m(this.f14724b, str);
            if (3 == i2) {
                TiebaStatic.log("c12649");
            } else if (1 == i2) {
                TiebaStatic.log("c12215");
            }
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.a == i2) {
            return;
        }
        this.a = i2;
        SkinManager.setBackgroundResource(this.f14726d, R.color.CAM_X0201);
        SkinManager.setImageResource(this.f14728f, R.drawable.live_portal_rank);
        SkinManager.setViewTextColor(this.f14729g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f14730h, R.color.CAM_X0109);
        SkinManager.setImageResource(this.f14732j, R.drawable.live_import_history);
        SkinManager.setViewTextColor(this.f14733k, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0109);
        SkinManager.setImageResource(this.o, R.drawable.live_import_activity);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0109);
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
            c.a.s0.s.g0.b.j().w(str, System.currentTimeMillis() / 1000);
            view.setVisibility(8);
        }
    }
}
