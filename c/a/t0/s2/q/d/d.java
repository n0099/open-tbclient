package c.a.t0.s2.q.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.s.k;
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
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f22988b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f22989c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22990d;

    /* renamed from: e  reason: collision with root package name */
    public e f22991e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22992f;

    /* renamed from: g  reason: collision with root package name */
    public BarImageView f22993g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22994h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f22995i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f22996j;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22997e;

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
            this.f22997e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22997e.f22991e == null) {
                return;
            }
            this.f22997e.f22991e.c();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f22998e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f22999f;

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
            this.f22999f = dVar;
            this.f22998e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22999f.e(this.f22998e.id.longValue(), this.f22998e.name);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f23000e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f23001f;

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
            this.f23001f = dVar;
            this.f23000e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23001f.e(this.f23000e.id.longValue(), this.f23000e.name);
            }
        }
    }

    /* renamed from: c.a.t0.s2.q.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1373d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f23002e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f23003f;

        public View$OnClickListenerC1373d(d dVar, String str) {
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
            this.f23003f = dVar;
            this.f23002e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23003f.f22991e == null) {
                return;
            }
            this.f23003f.f22991e.a(this.f23002e);
        }
    }

    /* loaded from: classes8.dex */
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
        this.a = inflate;
        this.f22988b = (TextView) inflate.findViewById(R.id.chosen_pb_title);
        this.f22989c = (HeadImageView) this.a.findViewById(R.id.chosen_pb_person_info_head);
        this.f22990d = (TextView) this.a.findViewById(R.id.chosen_pb_person_info_name);
        this.f22992f = (TextView) this.a.findViewById(R.id.chosen_pb_bar_forum_name);
        this.f22989c.setRadius(n.d(context, 2.0f));
        this.f22993g = (BarImageView) this.a.findViewById(R.id.chosen_pb_bar_pic);
        this.f22994h = (TextView) this.a.findViewById(R.id.chosen_pb_bar_attention_number);
        TextView textView = (TextView) this.a.findViewById(R.id.chosen_pb_bar_attention_button);
        this.f22995i = textView;
        textView.setOnClickListener(new a(this));
        this.f22996j = (LinearLayout) this.a.findViewById(R.id.chosen_pb_bar_container);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public void d(String str) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || (headImageView = this.f22989c) == null) {
            return;
        }
        headImageView.startLoad(str, 12, false);
    }

    public final void e(long j2, String str) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, str) == null) || (eVar = this.f22991e) == null) {
            return;
        }
        eVar.b(String.valueOf(j2), str);
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f22995i.setText(R.string.relate_forum_is_followed);
                SkinManager.setViewTextColor(this.f22995i, R.color.CAM_X0109, 1);
                this.f22995i.setEnabled(false);
                return;
            }
            this.f22995i.setText(R.string.attention);
            this.f22995i.setEnabled(true);
            SkinManager.setViewTextColor(this.f22995i, R.color.CAM_X0111, 1);
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f22991e = eVar;
        }
    }

    public void h(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (textView = this.f22990d) == null) {
            return;
        }
        textView.setText(str);
    }

    public final void i(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, context, str) == null) || this.f22992f == null) {
            return;
        }
        if (StringUtils.isNull(str)) {
            this.f22992f.setVisibility(4);
            return;
        }
        this.f22992f.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
        this.f22992f.setOnClickListener(new View$OnClickListenerC1373d(this, str));
        this.f22992f.setVisibility(0);
    }

    public void j(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        TextView textView;
        Integer num;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, context, excellentPbThreadInfo) == null) || excellentPbThreadInfo == null || (textView = this.f22988b) == null) {
            return;
        }
        textView.setText(excellentPbThreadInfo.title);
        if (!StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) && excellentPbThreadInfo.forum.forum_id != null && excellentPbThreadInfo.excid.longValue() > 0) {
            k.c().h(excellentPbThreadInfo.forum.forum_name);
            this.f22996j.setVisibility(0);
            i(context, excellentPbThreadInfo.forum.forum_name);
            BarImageView barImageView = this.f22993g;
            if (barImageView != null) {
                barImageView.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.f22993g.setOnClickListener(new View$OnClickListenerC1373d(this, excellentPbThreadInfo.forum.forum_name));
            }
            TextView textView2 = this.f22994h;
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
        this.f22996j.setVisibility(8);
    }

    public void update(UserInfo userInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, userInfo) == null) || userInfo == null) {
            return;
        }
        h(userInfo.name);
        d(userInfo.portrait);
        this.f22989c.setOnClickListener(new b(this, userInfo));
        this.f22990d.setOnClickListener(new c(this, userInfo));
    }
}
