package c.a.q0.v.d.b.c;

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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f25017a;

    /* renamed from: b  reason: collision with root package name */
    public Context f25018b;

    /* renamed from: c  reason: collision with root package name */
    public View f25019c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f25020d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f25021e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f25022f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25023g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25024h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f25025i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f25026j;
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

    /* renamed from: c.a.q0.v.d.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1166a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FunctionListInfo f25027e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f25028f;

        public View$OnClickListenerC1166a(a aVar, FunctionListInfo functionListInfo) {
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
            this.f25028f = aVar;
            this.f25027e = functionListInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25028f.k(1, this.f25027e.url);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25029e;

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
            this.f25029e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.f25029e.f25018b);
                    return;
                }
                a aVar = this.f25029e;
                aVar.n("prefer_key_history", aVar.m);
                this.f25029e.f25018b.startActivity(new Intent(this.f25029e.f25018b, AlaRecentHistoryActivity.class));
                TiebaStatic.log("c12648");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FunctionListInfo f25030e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f25031f;

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
            this.f25031f = aVar;
            this.f25030e = functionListInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25031f.k(3, this.f25030e.url);
                a aVar = this.f25031f;
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
        this.f25017a = 3;
        this.f25018b = tbPageContext.getPageActivity();
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
                        this.f25021e.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.f25023g.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.f25024h.setVisibility(0);
                            this.f25024h.setText(functionListInfo.describe);
                        }
                        this.f25021e.setOnClickListener(new View$OnClickListenerC1166a(this, functionListInfo));
                    } else if (intValue == 2) {
                        this.f25025i.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.k.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.l.setVisibility(0);
                            this.l.setText(functionListInfo.describe);
                        }
                        i(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.m);
                        this.f25025i.setOnClickListener(new b(this));
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
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? c.a.p0.s.d0.b.j().l(str, 0L) : invokeL.longValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25019c : (View) invokeV.objValue;
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
            View inflate = LayoutInflater.from(this.f25018b).inflate(R.layout.square_live_function_region_layout, (ViewGroup) null);
            this.f25019c = inflate;
            this.f25020d = (LinearLayout) inflate.findViewById(R.id.square_function_container);
            LinearLayout linearLayout = (LinearLayout) this.f25019c.findViewById(R.id.square_function_rank);
            this.f25021e = linearLayout;
            linearLayout.setVisibility(8);
            this.f25022f = (ImageView) this.f25019c.findViewById(R.id.square_function_rank_img);
            this.f25023g = (TextView) this.f25019c.findViewById(R.id.square_function_rank_title);
            this.f25024h = (TextView) this.f25019c.findViewById(R.id.square_function_rank_desc);
            LinearLayout linearLayout2 = (LinearLayout) this.f25019c.findViewById(R.id.square_function_history);
            this.f25025i = linearLayout2;
            linearLayout2.setVisibility(8);
            this.f25026j = (ImageView) this.f25019c.findViewById(R.id.square_function_history_img);
            this.k = (TextView) this.f25019c.findViewById(R.id.square_function_history_title);
            this.l = (TextView) this.f25019c.findViewById(R.id.square_function_history_desc);
            this.m = this.f25019c.findViewById(R.id.square_function_history_red_pointer);
            LinearLayout linearLayout3 = (LinearLayout) this.f25019c.findViewById(R.id.square_function_activity);
            this.n = linearLayout3;
            linearLayout3.setVisibility(8);
            this.o = (ImageView) this.f25019c.findViewById(R.id.square_function_activity_img);
            this.p = (TextView) this.f25019c.findViewById(R.id.square_function_activity_title);
            this.q = (TextView) this.f25019c.findViewById(R.id.square_function_activity_desc);
            this.r = this.f25019c.findViewById(R.id.square_function_activity_red_pointer);
            this.s = this.f25019c.findViewById(R.id.square_function_bottom_space);
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void k(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
            TiebaStatic.log(new StatisticItem("c12215"));
            c.a.p0.m.a.m(this.f25018b, str);
            if (3 == i2) {
                TiebaStatic.log("c12649");
            } else if (1 == i2) {
                TiebaStatic.log("c12215");
            }
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f25017a == i2) {
            return;
        }
        this.f25017a = i2;
        SkinManager.setBackgroundResource(this.f25020d, R.color.CAM_X0201);
        SkinManager.setImageResource(this.f25022f, R.drawable.live_portal_rank);
        SkinManager.setViewTextColor(this.f25023g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f25024h, R.color.CAM_X0109);
        SkinManager.setImageResource(this.f25026j, R.drawable.live_import_history);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
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
            c.a.p0.s.d0.b.j().w(str, System.currentTimeMillis() / 1000);
            view.setVisibility(8);
        }
    }
}
