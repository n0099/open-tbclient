package b.a.r0.m3.d;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadvert.view.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f21244a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f21245b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f21246c;

    /* renamed from: d  reason: collision with root package name */
    public d f21247d;

    /* renamed from: b.a.r0.m3.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1044a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21248e;

        public View$OnClickListenerC1044a(a aVar) {
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
            this.f21248e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21248e.f21247d == null) {
                return;
            }
            this.f21248e.f21247d.a();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21249e;

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
            this.f21249e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21249e.f21247d == null) {
                return;
            }
            this.f21249e.f21247d.b();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements CountDownTextView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21250a;

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
            this.f21250a = aVar;
        }

        @Override // com.baidu.tieba.tbadvert.view.CountDownTextView.c
        public void onTimeout(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21250a.f21247d == null) {
                return;
            }
            this.f21250a.f21247d.b();
        }
    }

    /* loaded from: classes5.dex */
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
        this.f21247d = dVar;
        this.f21244a = context;
        this.f21245b = new FrameLayout(context);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21245b : (View) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TextView textView = new TextView(this.f21244a);
            textView.setText(R.string.tb_ad_label);
            int dimension = (int) this.f21244a.getResources().getDimension(R.dimen.ds28);
            textView.setTextSize(0, (int) this.f21244a.getResources().getDimension(R.dimen.ds22));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.f21244a.getResources().getDimension(R.dimen.ds68), (int) this.f21244a.getResources().getDimension(R.dimen.ds40));
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setAlpha(0.5f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-16777216);
            gradientDrawable.setCornerRadius(this.f21244a.getResources().getDimension(R.dimen.ds4));
            gradientDrawable.setStroke(1, -16777216);
            textView.setBackgroundDrawable(gradientDrawable);
            layoutParams.gravity = 83;
            layoutParams.setMargins(dimension, 0, 0, (int) this.f21244a.getResources().getDimension(R.dimen.ds28));
            this.f21245b.addView(textView, layoutParams);
        }
    }

    public final void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            CountDownTextView countDownTextView = new CountDownTextView(this.f21244a);
            int dimension = (int) this.f21244a.getResources().getDimension(R.dimen.ds22);
            int dimension2 = (int) this.f21244a.getResources().getDimension(R.dimen.ds36);
            Context context = this.f21244a;
            if ((context instanceof Activity) && (UtilHelper.isNotchScreen((Activity) context) || UtilHelper.isCutoutScreen((Activity) this.f21244a))) {
                dimension2 += l.r((Activity) this.f21244a);
            }
            String string = this.f21244a.getResources().getString(R.string.skip);
            countDownTextView.setTextSize(0, dimension);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.f21244a.getResources().getDimension(R.dimen.ds106), (int) this.f21244a.getResources().getDimension(R.dimen.ds52));
            countDownTextView.setTextColor(-1);
            countDownTextView.setGravity(17);
            countDownTextView.setAlpha(0.5f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-16777216);
            gradientDrawable.setCornerRadius(this.f21244a.getResources().getDimension(R.dimen.ds4));
            gradientDrawable.setStroke(1, -16777216);
            countDownTextView.setBackgroundDrawable(gradientDrawable);
            countDownTextView.init(string, i2);
            layoutParams.gravity = 53;
            layoutParams.setMargins(0, dimension2, (int) this.f21244a.getResources().getDimension(R.dimen.ds32), 0);
            this.f21245b.addView(countDownTextView, layoutParams);
            countDownTextView.setOnClickListener(new b(this));
            countDownTextView.setTimeoutListener(new c(this));
        }
    }

    public final void f(b.a.e.l.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            ImageView imageView = new ImageView(this.f21244a);
            this.f21246c = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (aVar != null) {
                this.f21246c.setImageBitmap(aVar.p());
            }
            this.f21246c.setOnClickListener(new View$OnClickListenerC1044a(this));
            this.f21245b.addView(this.f21246c);
        }
    }

    public void g(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, obj, i2) == null) {
            if (obj instanceof b.a.e.l.d.a) {
                f((b.a.e.l.d.a) obj);
            }
            d();
            e(i2);
        }
    }
}
