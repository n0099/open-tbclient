package c.a.r0.j2.g.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f19578a;

    /* renamed from: b  reason: collision with root package name */
    public View f19579b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19580c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f19581d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19582e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19583f;

    /* renamed from: g  reason: collision with root package name */
    public c f19584g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19585h;

    /* renamed from: i  reason: collision with root package name */
    public long f19586i;

    /* renamed from: j  reason: collision with root package name */
    public Animation f19587j;
    public boolean k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f19588e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19588e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !this.f19588e.k && ViewHelper.checkUpIsLogin(this.f19588e.f19578a)) {
                this.f19588e.k = true;
                this.f19588e.f19581d.startAnimation(this.f19588e.g());
                if (this.f19588e.f19584g != null) {
                    this.f19588e.f19584g.b(this.f19588e.f19585h);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExcellentPbThreadInfo f19589e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f19590f;

        public b(e eVar, ExcellentPbThreadInfo excellentPbThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, excellentPbThreadInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19590f = eVar;
            this.f19589e = excellentPbThreadInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19590f.f19584g == null) {
                return;
            }
            c cVar = this.f19590f.f19584g;
            long longValue = this.f19589e.forum.forum_id.longValue();
            cVar.a(longValue, this.f19589e.thread_id + "");
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(long j2, String str);

        void b(boolean z);
    }

    public e(Context context) {
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
        this.f19586i = 0L;
        this.k = false;
        this.f19578a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.f19579b = inflate;
        this.f19580c = (TextView) inflate.findViewById(R.id.chosen_post_info_copyright);
        this.f19581d = (ImageView) this.f19579b.findViewById(R.id.chosen_post_info_praise_icon);
        this.f19582e = (TextView) this.f19579b.findViewById(R.id.chosen_post_info_praise_num);
        this.f19583f = (TextView) this.f19579b.findViewById(R.id.chosen_post_info_original_post);
    }

    public final Animation g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f19587j == null) {
                this.f19587j = AnimationUtils.loadAnimation(this.f19578a, R.anim.praise_animation_scale3);
            }
            return this.f19587j;
        }
        return (Animation) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19579b : (View) invokeV.objValue;
    }

    public void i(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f19584g = cVar;
        }
    }

    public void j(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (textView = this.f19580c) == null) {
            return;
        }
        textView.setText(i2);
    }

    public void k(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (textView = this.f19583f) == null) {
            return;
        }
        textView.setOnClickListener(onClickListener);
    }

    public void l(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) || j2 < 0) {
            return;
        }
        this.f19586i = j2;
        TextView textView = this.f19582e;
        if (textView != null) {
            textView.setVisibility(0);
            this.f19582e.setText(this.f19578a.getString(R.string.chosen_pb_praise_num, StringHelper.numFormatOver10000(j2)));
        }
        TextView textView2 = this.f19582e;
        if (textView2 == null || textView2.getVisibility() != 8) {
            return;
        }
        this.f19582e.setVisibility(0);
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            p(z);
            if (z) {
                this.f19586i++;
            } else {
                this.f19586i--;
            }
            l(this.f19586i);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k = false;
        }
    }

    public void o(ExcellentPbThreadInfo excellentPbThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, excellentPbThreadInfo) == null) || excellentPbThreadInfo == null) {
            return;
        }
        j(R.string.chosen_pb_copyright);
        l(excellentPbThreadInfo.zan.zansum.longValue());
        p(excellentPbThreadInfo.zan.is_zan.booleanValue());
        this.f19581d.setOnClickListener(new a(this));
        k(new b(this, excellentPbThreadInfo));
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f19585h = z;
            if (z) {
                SkinManager.setImageResource(this.f19581d, R.drawable.btn_zambia_big_s);
            } else {
                SkinManager.setImageResource(this.f19581d, R.drawable.btn_zambia_big_n);
            }
            this.f19581d.setVisibility(0);
        }
    }
}
