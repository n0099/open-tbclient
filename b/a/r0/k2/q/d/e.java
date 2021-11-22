package b.a.r0.k2.q.d;

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
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f20261a;

    /* renamed from: b  reason: collision with root package name */
    public View f20262b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20263c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f20264d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20265e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20266f;

    /* renamed from: g  reason: collision with root package name */
    public c f20267g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20268h;

    /* renamed from: i  reason: collision with root package name */
    public long f20269i;
    public Animation j;
    public boolean k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f20270e;

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
            this.f20270e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !this.f20270e.k && ViewHelper.checkUpIsLogin(this.f20270e.f20261a)) {
                this.f20270e.k = true;
                this.f20270e.f20264d.startAnimation(this.f20270e.g());
                if (this.f20270e.f20267g != null) {
                    this.f20270e.f20267g.b(this.f20270e.f20268h);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExcellentPbThreadInfo f20271e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f20272f;

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
            this.f20272f = eVar;
            this.f20271e = excellentPbThreadInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20272f.f20267g == null) {
                return;
            }
            c cVar = this.f20272f.f20267g;
            long longValue = this.f20271e.forum.forum_id.longValue();
            cVar.a(longValue, this.f20271e.thread_id + "");
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(long j, String str);

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
        this.f20269i = 0L;
        this.k = false;
        this.f20261a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.f20262b = inflate;
        this.f20263c = (TextView) inflate.findViewById(R.id.chosen_post_info_copyright);
        this.f20264d = (ImageView) this.f20262b.findViewById(R.id.chosen_post_info_praise_icon);
        this.f20265e = (TextView) this.f20262b.findViewById(R.id.chosen_post_info_praise_num);
        this.f20266f = (TextView) this.f20262b.findViewById(R.id.chosen_post_info_original_post);
    }

    public final Animation g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.j == null) {
                this.j = AnimationUtils.loadAnimation(this.f20261a, R.anim.praise_animation_scale3);
            }
            return this.j;
        }
        return (Animation) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20262b : (View) invokeV.objValue;
    }

    public void i(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f20267g = cVar;
        }
    }

    public void j(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (textView = this.f20263c) == null) {
            return;
        }
        textView.setText(i2);
    }

    public void k(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (textView = this.f20266f) == null) {
            return;
        }
        textView.setOnClickListener(onClickListener);
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048581, this, j) == null) || j < 0) {
            return;
        }
        this.f20269i = j;
        TextView textView = this.f20265e;
        if (textView != null) {
            textView.setVisibility(0);
            this.f20265e.setText(this.f20261a.getString(R.string.chosen_pb_praise_num, StringHelper.numFormatOver10000(j)));
        }
        TextView textView2 = this.f20265e;
        if (textView2 == null || textView2.getVisibility() != 8) {
            return;
        }
        this.f20265e.setVisibility(0);
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            o(z);
            if (z) {
                this.f20269i++;
            } else {
                this.f20269i--;
            }
            l(this.f20269i);
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
            this.f20268h = z;
            if (z) {
                SkinManager.setImageResource(this.f20264d, R.drawable.btn_zambia_big_s);
            } else {
                SkinManager.setImageResource(this.f20264d, R.drawable.btn_zambia_big_n);
            }
            this.f20264d.setVisibility(0);
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
        this.f20264d.setOnClickListener(new a(this));
        k(new b(this, excellentPbThreadInfo));
    }
}
