package c.a.q0.i2.g.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.p0.s.k;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f19012a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f19013b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f19014c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19015d;

    /* renamed from: e  reason: collision with root package name */
    public e f19016e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19017f;

    /* renamed from: g  reason: collision with root package name */
    public BarImageView f19018g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19019h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19020i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f19021j;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f19022e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19022e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19022e.f19016e == null) {
                return;
            }
            this.f19022e.f19016e.c();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f19023e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f19024f;

        public b(d dVar, UserInfo userInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, userInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19024f = dVar;
            this.f19023e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19024f.e(this.f19023e.id.longValue(), this.f19023e.name);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f19025e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f19026f;

        public c(d dVar, UserInfo userInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, userInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19026f = dVar;
            this.f19025e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19026f.e(this.f19025e.id.longValue(), this.f19025e.name);
            }
        }
    }

    /* renamed from: c.a.q0.i2.g.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0912d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f19027e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f19028f;

        public View$OnClickListenerC0912d(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19028f = dVar;
            this.f19027e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19028f.f19016e == null) {
                return;
            }
            this.f19028f.f19016e.a(this.f19027e);
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(String str);

        void b(String str, String str2);

        void c();
    }

    public d(Context context) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.f19012a = inflate;
        this.f19013b = (TextView) inflate.findViewById(R.id.chosen_pb_title);
        this.f19014c = (HeadImageView) this.f19012a.findViewById(R.id.chosen_pb_person_info_head);
        this.f19015d = (TextView) this.f19012a.findViewById(R.id.chosen_pb_person_info_name);
        this.f19017f = (TextView) this.f19012a.findViewById(R.id.chosen_pb_bar_forum_name);
        this.f19014c.setRadius(l.e(context, 2.0f));
        this.f19018g = (BarImageView) this.f19012a.findViewById(R.id.chosen_pb_bar_pic);
        this.f19019h = (TextView) this.f19012a.findViewById(R.id.chosen_pb_bar_attention_number);
        TextView textView = (TextView) this.f19012a.findViewById(R.id.chosen_pb_bar_attention_button);
        this.f19020i = textView;
        textView.setOnClickListener(new a(this));
        this.f19021j = (LinearLayout) this.f19012a.findViewById(R.id.chosen_pb_bar_container);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19012a : (View) invokeV.objValue;
    }

    public void d(String str) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || (headImageView = this.f19014c) == null) {
            return;
        }
        headImageView.startLoad(str, 12, false);
    }

    public final void e(long j2, String str) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, str) == null) || (eVar = this.f19016e) == null) {
            return;
        }
        eVar.b(String.valueOf(j2), str);
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f19020i.setText(R.string.relate_forum_is_followed);
                SkinManager.setViewTextColor(this.f19020i, R.color.CAM_X0109, 1);
                this.f19020i.setEnabled(false);
                return;
            }
            this.f19020i.setText(R.string.attention);
            this.f19020i.setEnabled(true);
            SkinManager.setViewTextColor(this.f19020i, R.color.CAM_X0111, 1);
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f19016e = eVar;
        }
    }

    public void h(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (textView = this.f19015d) == null) {
            return;
        }
        textView.setText(str);
    }

    public final void i(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, context, str) == null) || this.f19017f == null) {
            return;
        }
        if (StringUtils.isNull(str)) {
            this.f19017f.setVisibility(4);
            return;
        }
        this.f19017f.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
        this.f19017f.setOnClickListener(new View$OnClickListenerC0912d(this, str));
        this.f19017f.setVisibility(0);
    }

    public void j(UserInfo userInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, userInfo) == null) || userInfo == null) {
            return;
        }
        h(userInfo.name);
        d(userInfo.portrait);
        this.f19014c.setOnClickListener(new b(this, userInfo));
        this.f19015d.setOnClickListener(new c(this, userInfo));
    }

    public void k(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        TextView textView;
        Integer num;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, excellentPbThreadInfo) == null) || excellentPbThreadInfo == null || (textView = this.f19013b) == null) {
            return;
        }
        textView.setText(excellentPbThreadInfo.title);
        if (!StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) && excellentPbThreadInfo.forum.forum_id != null && excellentPbThreadInfo.excid.longValue() > 0) {
            k.c().h(excellentPbThreadInfo.forum.forum_name);
            this.f19021j.setVisibility(0);
            i(context, excellentPbThreadInfo.forum.forum_name);
            BarImageView barImageView = this.f19018g;
            if (barImageView != null) {
                barImageView.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.f19018g.setOnClickListener(new View$OnClickListenerC0912d(this, excellentPbThreadInfo.forum.forum_name));
            }
            TextView textView2 = this.f19019h;
            if (textView2 != null && (num = excellentPbThreadInfo.forum.member_count) != null) {
                textView2.setText(StringHelper.numFormatOver10000(num.intValue()));
            }
            Integer num2 = excellentPbThreadInfo.forum.is_like;
            if (num2 != null && num2.intValue() == 1) {
                f(true);
                return;
            } else {
                f(false);
                return;
            }
        }
        this.f19021j.setVisibility(8);
    }
}
