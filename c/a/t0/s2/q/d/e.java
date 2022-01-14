package c.a.t0.s2.q.d;

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
    public View f22372b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f22373c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f22374d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22375e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22376f;

    /* renamed from: g  reason: collision with root package name */
    public c f22377g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22378h;

    /* renamed from: i  reason: collision with root package name */
    public long f22379i;

    /* renamed from: j  reason: collision with root package name */
    public Animation f22380j;
    public boolean k;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f22381e;

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
            this.f22381e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !this.f22381e.k && ViewHelper.checkUpIsLogin(this.f22381e.a)) {
                this.f22381e.k = true;
                this.f22381e.f22374d.startAnimation(this.f22381e.g());
                if (this.f22381e.f22377g != null) {
                    this.f22381e.f22377g.b(this.f22381e.f22378h);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExcellentPbThreadInfo f22382e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f22383f;

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
            this.f22383f = eVar;
            this.f22382e = excellentPbThreadInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22383f.f22377g == null) {
                return;
            }
            c cVar = this.f22383f.f22377g;
            long longValue = this.f22382e.forum.forum_id.longValue();
            cVar.a(longValue, this.f22382e.thread_id + "");
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
        this.f22379i = 0L;
        this.k = false;
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.f22372b = inflate;
        this.f22373c = (TextView) inflate.findViewById(R.id.chosen_post_info_copyright);
        this.f22374d = (ImageView) this.f22372b.findViewById(R.id.chosen_post_info_praise_icon);
        this.f22375e = (TextView) this.f22372b.findViewById(R.id.chosen_post_info_praise_num);
        this.f22376f = (TextView) this.f22372b.findViewById(R.id.chosen_post_info_original_post);
    }

    public final Animation g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f22380j == null) {
                this.f22380j = AnimationUtils.loadAnimation(this.a, R.anim.praise_animation_scale3);
            }
            return this.f22380j;
        }
        return (Animation) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22372b : (View) invokeV.objValue;
    }

    public void i(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f22377g = cVar;
        }
    }

    public void j(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (textView = this.f22373c) == null) {
            return;
        }
        textView.setText(i2);
    }

    public void k(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (textView = this.f22376f) == null) {
            return;
        }
        textView.setOnClickListener(onClickListener);
    }

    public void l(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) || j2 < 0) {
            return;
        }
        this.f22379i = j2;
        TextView textView = this.f22375e;
        if (textView != null) {
            textView.setVisibility(0);
            this.f22375e.setText(this.a.getString(R.string.chosen_pb_praise_num, StringHelper.numFormatOver10000(j2)));
        }
        TextView textView2 = this.f22375e;
        if (textView2 == null || textView2.getVisibility() != 8) {
            return;
        }
        this.f22375e.setVisibility(0);
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            o(z);
            if (z) {
                this.f22379i++;
            } else {
                this.f22379i--;
            }
            l(this.f22379i);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k = false;
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f22378h = z;
            if (z) {
                SkinManager.setImageResource(this.f22374d, R.drawable.btn_zambia_big_s);
            } else {
                SkinManager.setImageResource(this.f22374d, R.drawable.btn_zambia_big_n);
            }
            this.f22374d.setVisibility(0);
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
        this.f22374d.setOnClickListener(new a(this));
        k(new b(this, excellentPbThreadInfo));
    }
}
