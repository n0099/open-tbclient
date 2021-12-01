package c.a.r0.u3.d;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadvert.view.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f24570b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f24571c;

    /* renamed from: d  reason: collision with root package name */
    public d f24572d;

    /* renamed from: c.a.r0.u3.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1400a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24573e;

        public View$OnClickListenerC1400a(a aVar) {
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
            this.f24573e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f24573e.f24572d == null) {
                return;
            }
            this.f24573e.f24572d.a();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24574e;

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
            this.f24574e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f24574e.f24572d == null) {
                return;
            }
            this.f24574e.f24572d.b();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements CountDownTextView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
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
            this.a = aVar;
        }

        @Override // com.baidu.tieba.tbadvert.view.CountDownTextView.c
        public void onTimeout(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f24572d == null) {
                return;
            }
            this.a.f24572d.b();
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a();

        void b();
    }

    public a(Context context, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24572d = dVar;
        this.a = context;
        this.f24570b = new FrameLayout(context);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24570b : (View) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TextView textView = new TextView(this.a);
            textView.setText(R.string.tb_ad_label);
            int dimension = (int) this.a.getResources().getDimension(R.dimen.ds28);
            textView.setTextSize(0, (int) this.a.getResources().getDimension(R.dimen.ds22));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.a.getResources().getDimension(R.dimen.ds68), (int) this.a.getResources().getDimension(R.dimen.ds40));
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setAlpha(0.5f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-16777216);
            gradientDrawable.setCornerRadius(this.a.getResources().getDimension(R.dimen.ds4));
            gradientDrawable.setStroke(1, -16777216);
            textView.setBackgroundDrawable(gradientDrawable);
            layoutParams.gravity = 83;
            layoutParams.setMargins(dimension, 0, 0, (int) this.a.getResources().getDimension(R.dimen.ds28));
            this.f24570b.addView(textView, layoutParams);
        }
    }

    public final void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            CountDownTextView countDownTextView = new CountDownTextView(this.a);
            int dimension = (int) this.a.getResources().getDimension(R.dimen.ds22);
            int dimension2 = (int) this.a.getResources().getDimension(R.dimen.ds36);
            Context context = this.a;
            if ((context instanceof Activity) && (UtilHelper.isNotchScreen((Activity) context) || UtilHelper.isCutoutScreen((Activity) this.a))) {
                dimension2 += l.r((Activity) this.a);
            }
            String string = this.a.getResources().getString(R.string.skip);
            countDownTextView.setTextSize(0, dimension);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.a.getResources().getDimension(R.dimen.ds106), (int) this.a.getResources().getDimension(R.dimen.ds52));
            countDownTextView.setTextColor(-1);
            countDownTextView.setGravity(17);
            countDownTextView.setAlpha(0.5f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-16777216);
            gradientDrawable.setCornerRadius(this.a.getResources().getDimension(R.dimen.ds4));
            gradientDrawable.setStroke(1, -16777216);
            countDownTextView.setBackgroundDrawable(gradientDrawable);
            countDownTextView.init(string, i2);
            layoutParams.gravity = 53;
            layoutParams.setMargins(0, dimension2, (int) this.a.getResources().getDimension(R.dimen.ds32), 0);
            this.f24570b.addView(countDownTextView, layoutParams);
            countDownTextView.setOnClickListener(new b(this));
            countDownTextView.setTimeoutListener(new c(this));
        }
    }

    public final void f(c.a.d.m.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            ImageView imageView = new ImageView(this.a);
            this.f24571c = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (aVar != null) {
                this.f24571c.setImageBitmap(aVar.p());
            }
            this.f24571c.setOnClickListener(new View$OnClickListenerC1400a(this));
            this.f24570b.addView(this.f24571c);
        }
    }

    public void g(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, obj, i2) == null) {
            if (obj instanceof c.a.d.m.d.a) {
                f((c.a.d.m.d.a) obj);
            }
            d();
            e(i2);
        }
    }
}
