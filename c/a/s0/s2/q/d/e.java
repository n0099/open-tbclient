package c.a.s0.s2.q.d;

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
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f22492b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f22493c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f22494d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22495e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22496f;

    /* renamed from: g  reason: collision with root package name */
    public c f22497g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22498h;

    /* renamed from: i  reason: collision with root package name */
    public long f22499i;

    /* renamed from: j  reason: collision with root package name */
    public Animation f22500j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f22501k;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f22502e;

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
            this.f22502e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !this.f22502e.f22501k && ViewHelper.checkUpIsLogin(this.f22502e.a)) {
                this.f22502e.f22501k = true;
                this.f22502e.f22494d.startAnimation(this.f22502e.g());
                if (this.f22502e.f22497g != null) {
                    this.f22502e.f22497g.b(this.f22502e.f22498h);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExcellentPbThreadInfo f22503e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f22504f;

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
            this.f22504f = eVar;
            this.f22503e = excellentPbThreadInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22504f.f22497g == null) {
                return;
            }
            c cVar = this.f22504f.f22497g;
            long longValue = this.f22503e.forum.forum_id.longValue();
            cVar.a(longValue, this.f22503e.thread_id + "");
        }
    }

    /* loaded from: classes8.dex */
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
        this.f22499i = 0L;
        this.f22501k = false;
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.f22492b = inflate;
        this.f22493c = (TextView) inflate.findViewById(R.id.chosen_post_info_copyright);
        this.f22494d = (ImageView) this.f22492b.findViewById(R.id.chosen_post_info_praise_icon);
        this.f22495e = (TextView) this.f22492b.findViewById(R.id.chosen_post_info_praise_num);
        this.f22496f = (TextView) this.f22492b.findViewById(R.id.chosen_post_info_original_post);
    }

    public final Animation g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f22500j == null) {
                this.f22500j = AnimationUtils.loadAnimation(this.a, R.anim.praise_animation_scale3);
            }
            return this.f22500j;
        }
        return (Animation) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22492b : (View) invokeV.objValue;
    }

    public void i(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f22497g = cVar;
        }
    }

    public void j(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (textView = this.f22493c) == null) {
            return;
        }
        textView.setText(i2);
    }

    public void k(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (textView = this.f22496f) == null) {
            return;
        }
        textView.setOnClickListener(onClickListener);
    }

    public void l(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) || j2 < 0) {
            return;
        }
        this.f22499i = j2;
        TextView textView = this.f22495e;
        if (textView != null) {
            textView.setVisibility(0);
            this.f22495e.setText(this.a.getString(R.string.chosen_pb_praise_num, StringHelper.numFormatOver10000(j2)));
        }
        TextView textView2 = this.f22495e;
        if (textView2 == null || textView2.getVisibility() != 8) {
            return;
        }
        this.f22495e.setVisibility(0);
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            o(z);
            if (z) {
                this.f22499i++;
            } else {
                this.f22499i--;
            }
            l(this.f22499i);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f22501k = false;
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f22498h = z;
            if (z) {
                SkinManager.setImageResource(this.f22494d, R.drawable.btn_zambia_big_s);
            } else {
                SkinManager.setImageResource(this.f22494d, R.drawable.btn_zambia_big_n);
            }
            this.f22494d.setVisibility(0);
        }
    }

    public void update(ExcellentPbThreadInfo excellentPbThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, excellentPbThreadInfo) == null) || excellentPbThreadInfo == null) {
            return;
        }
        j(R.string.chosen_pb_copyright);
        l(excellentPbThreadInfo.zan.zansum.longValue());
        o(excellentPbThreadInfo.zan.is_zan.booleanValue());
        this.f22494d.setOnClickListener(new a(this));
        k(new b(this, excellentPbThreadInfo));
    }
}
