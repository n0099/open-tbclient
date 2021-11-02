package b.a.r0.k2.q.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.s.k;
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
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f18709a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f18710b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f18711c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f18712d;

    /* renamed from: e  reason: collision with root package name */
    public e f18713e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18714f;

    /* renamed from: g  reason: collision with root package name */
    public BarImageView f18715g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18716h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18717i;
    public LinearLayout j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f18718e;

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
            this.f18718e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18718e.f18713e == null) {
                return;
            }
            this.f18718e.f18713e.c();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f18719e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f18720f;

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
            this.f18720f = dVar;
            this.f18719e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18720f.e(this.f18719e.id.longValue(), this.f18719e.name);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserInfo f18721e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f18722f;

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
            this.f18722f = dVar;
            this.f18721e = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18722f.e(this.f18721e.id.longValue(), this.f18721e.name);
            }
        }
    }

    /* renamed from: b.a.r0.k2.q.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC0948d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f18723e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f18724f;

        public View$OnClickListenerC0948d(d dVar, String str) {
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
            this.f18724f = dVar;
            this.f18723e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18724f.f18713e == null) {
                return;
            }
            this.f18724f.f18713e.a(this.f18723e);
        }
    }

    /* loaded from: classes5.dex */
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
        this.f18709a = inflate;
        this.f18710b = (TextView) inflate.findViewById(R.id.chosen_pb_title);
        this.f18711c = (HeadImageView) this.f18709a.findViewById(R.id.chosen_pb_person_info_head);
        this.f18712d = (TextView) this.f18709a.findViewById(R.id.chosen_pb_person_info_name);
        this.f18714f = (TextView) this.f18709a.findViewById(R.id.chosen_pb_bar_forum_name);
        this.f18711c.setRadius(l.e(context, 2.0f));
        this.f18715g = (BarImageView) this.f18709a.findViewById(R.id.chosen_pb_bar_pic);
        this.f18716h = (TextView) this.f18709a.findViewById(R.id.chosen_pb_bar_attention_number);
        TextView textView = (TextView) this.f18709a.findViewById(R.id.chosen_pb_bar_attention_button);
        this.f18717i = textView;
        textView.setOnClickListener(new a(this));
        this.j = (LinearLayout) this.f18709a.findViewById(R.id.chosen_pb_bar_container);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18709a : (View) invokeV.objValue;
    }

    public void d(String str) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || (headImageView = this.f18711c) == null) {
            return;
        }
        headImageView.startLoad(str, 12, false);
    }

    public final void e(long j, String str) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, str) == null) || (eVar = this.f18713e) == null) {
            return;
        }
        eVar.b(String.valueOf(j), str);
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f18717i.setText(R.string.relate_forum_is_followed);
                SkinManager.setViewTextColor(this.f18717i, R.color.CAM_X0109, 1);
                this.f18717i.setEnabled(false);
                return;
            }
            this.f18717i.setText(R.string.attention);
            this.f18717i.setEnabled(true);
            SkinManager.setViewTextColor(this.f18717i, R.color.CAM_X0111, 1);
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f18713e = eVar;
        }
    }

    public void h(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (textView = this.f18712d) == null) {
            return;
        }
        textView.setText(str);
    }

    public final void i(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, context, str) == null) || this.f18714f == null) {
            return;
        }
        if (StringUtils.isNull(str)) {
            this.f18714f.setVisibility(4);
            return;
        }
        this.f18714f.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
        this.f18714f.setOnClickListener(new View$OnClickListenerC0948d(this, str));
        this.f18714f.setVisibility(0);
    }

    public void j(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        TextView textView;
        Integer num;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, context, excellentPbThreadInfo) == null) || excellentPbThreadInfo == null || (textView = this.f18710b) == null) {
            return;
        }
        textView.setText(excellentPbThreadInfo.title);
        if (!StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) && excellentPbThreadInfo.forum.forum_id != null && excellentPbThreadInfo.excid.longValue() > 0) {
            k.c().h(excellentPbThreadInfo.forum.forum_name);
            this.j.setVisibility(0);
            i(context, excellentPbThreadInfo.forum.forum_name);
            BarImageView barImageView = this.f18715g;
            if (barImageView != null) {
                barImageView.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.f18715g.setOnClickListener(new View$OnClickListenerC0948d(this, excellentPbThreadInfo.forum.forum_name));
            }
            TextView textView2 = this.f18716h;
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
        this.j.setVisibility(8);
    }

    public void update(UserInfo userInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, userInfo) == null) || userInfo == null) {
            return;
        }
        h(userInfo.name);
        d(userInfo.portrait);
        this.f18711c.setOnClickListener(new b(this, userInfo));
        this.f18712d.setOnClickListener(new c(this, userInfo));
    }
}
