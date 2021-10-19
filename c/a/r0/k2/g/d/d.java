package c.a.r0.k2.g.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.k;
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
    public View f19753a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f19754b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f19755c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19756d;

    /* renamed from: e  reason: collision with root package name */
    public e f19757e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19758f;

    /* renamed from: g  reason: collision with root package name */
    public BarImageView f19759g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19760h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19761i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f19762j;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f19763e;

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
            this.f19763e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19763e.f19757e == null) {
                return;
            }
            this.f19763e.f19757e.c();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f19764e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f19765f;

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
            this.f19765f = dVar;
            this.f19764e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19765f.e(this.f19764e.id.longValue(), this.f19764e.name);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f19766e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f19767f;

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
            this.f19767f = dVar;
            this.f19766e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19767f.e(this.f19766e.id.longValue(), this.f19766e.name);
            }
        }
    }

    /* renamed from: c.a.r0.k2.g.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0951d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f19768e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f19769f;

        public View$OnClickListenerC0951d(d dVar, String str) {
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
            this.f19769f = dVar;
            this.f19768e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19769f.f19757e == null) {
                return;
            }
            this.f19769f.f19757e.a(this.f19768e);
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
        this.f19753a = inflate;
        this.f19754b = (TextView) inflate.findViewById(R.id.chosen_pb_title);
        this.f19755c = (HeadImageView) this.f19753a.findViewById(R.id.chosen_pb_person_info_head);
        this.f19756d = (TextView) this.f19753a.findViewById(R.id.chosen_pb_person_info_name);
        this.f19758f = (TextView) this.f19753a.findViewById(R.id.chosen_pb_bar_forum_name);
        this.f19755c.setRadius(l.e(context, 2.0f));
        this.f19759g = (BarImageView) this.f19753a.findViewById(R.id.chosen_pb_bar_pic);
        this.f19760h = (TextView) this.f19753a.findViewById(R.id.chosen_pb_bar_attention_number);
        TextView textView = (TextView) this.f19753a.findViewById(R.id.chosen_pb_bar_attention_button);
        this.f19761i = textView;
        textView.setOnClickListener(new a(this));
        this.f19762j = (LinearLayout) this.f19753a.findViewById(R.id.chosen_pb_bar_container);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19753a : (View) invokeV.objValue;
    }

    public void d(String str) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || (headImageView = this.f19755c) == null) {
            return;
        }
        headImageView.startLoad(str, 12, false);
    }

    public final void e(long j2, String str) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, str) == null) || (eVar = this.f19757e) == null) {
            return;
        }
        eVar.b(String.valueOf(j2), str);
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f19761i.setText(R.string.relate_forum_is_followed);
                SkinManager.setViewTextColor(this.f19761i, R.color.CAM_X0109, 1);
                this.f19761i.setEnabled(false);
                return;
            }
            this.f19761i.setText(R.string.attention);
            this.f19761i.setEnabled(true);
            SkinManager.setViewTextColor(this.f19761i, R.color.CAM_X0111, 1);
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f19757e = eVar;
        }
    }

    public void h(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (textView = this.f19756d) == null) {
            return;
        }
        textView.setText(str);
    }

    public final void i(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, context, str) == null) || this.f19758f == null) {
            return;
        }
        if (StringUtils.isNull(str)) {
            this.f19758f.setVisibility(4);
            return;
        }
        this.f19758f.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
        this.f19758f.setOnClickListener(new View$OnClickListenerC0951d(this, str));
        this.f19758f.setVisibility(0);
    }

    public void j(UserInfo userInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, userInfo) == null) || userInfo == null) {
            return;
        }
        h(userInfo.name);
        d(userInfo.portrait);
        this.f19755c.setOnClickListener(new b(this, userInfo));
        this.f19756d.setOnClickListener(new c(this, userInfo));
    }

    public void k(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        TextView textView;
        Integer num;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, excellentPbThreadInfo) == null) || excellentPbThreadInfo == null || (textView = this.f19754b) == null) {
            return;
        }
        textView.setText(excellentPbThreadInfo.title);
        if (!StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) && excellentPbThreadInfo.forum.forum_id != null && excellentPbThreadInfo.excid.longValue() > 0) {
            k.c().h(excellentPbThreadInfo.forum.forum_name);
            this.f19762j.setVisibility(0);
            i(context, excellentPbThreadInfo.forum.forum_name);
            BarImageView barImageView = this.f19759g;
            if (barImageView != null) {
                barImageView.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.f19759g.setOnClickListener(new View$OnClickListenerC0951d(this, excellentPbThreadInfo.forum.forum_name));
            }
            TextView textView2 = this.f19760h;
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
        this.f19762j.setVisibility(8);
    }
}
