package c.a.p0.j3.d;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadvert.view.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f20872a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f20873b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f20874c;

    /* renamed from: d  reason: collision with root package name */
    public d f20875d;

    /* renamed from: c.a.p0.j3.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0979a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20876e;

        public View$OnClickListenerC0979a(a aVar) {
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
            this.f20876e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20876e.f20875d == null) {
                return;
            }
            this.f20876e.f20875d.a();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20877e;

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
            this.f20877e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20877e.f20875d == null) {
                return;
            }
            this.f20877e.f20875d.b();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements CountDownTextView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20878a;

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
            this.f20878a = aVar;
        }

        @Override // com.baidu.tieba.tbadvert.view.CountDownTextView.c
        public void onTimeout(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20878a.f20875d == null) {
                return;
            }
            this.f20878a.f20875d.b();
        }
    }

    /* loaded from: classes3.dex */
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
        this.f20875d = dVar;
        this.f20872a = context;
        this.f20873b = new FrameLayout(context);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20873b : (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TextView textView = new TextView(this.f20872a);
            textView.setText(R.string.tb_ad_label);
            int dimension = (int) this.f20872a.getResources().getDimension(R.dimen.ds28);
            textView.setTextSize(0, (int) this.f20872a.getResources().getDimension(R.dimen.ds22));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.f20872a.getResources().getDimension(R.dimen.ds68), (int) this.f20872a.getResources().getDimension(R.dimen.ds40));
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setAlpha(0.5f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-16777216);
            gradientDrawable.setCornerRadius(this.f20872a.getResources().getDimension(R.dimen.ds4));
            gradientDrawable.setStroke(1, -16777216);
            textView.setBackgroundDrawable(gradientDrawable);
            layoutParams.gravity = 83;
            layoutParams.setMargins(dimension, 0, 0, (int) this.f20872a.getResources().getDimension(R.dimen.ds28));
            this.f20873b.addView(textView, layoutParams);
        }
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            CountDownTextView countDownTextView = new CountDownTextView(this.f20872a);
            int dimension = (int) this.f20872a.getResources().getDimension(R.dimen.ds22);
            int dimension2 = (int) this.f20872a.getResources().getDimension(R.dimen.ds36);
            Context context = this.f20872a;
            if ((context instanceof Activity) && (UtilHelper.isNotchScreen((Activity) context) || UtilHelper.isCutoutScreen((Activity) this.f20872a))) {
                dimension2 += l.r((Activity) this.f20872a);
            }
            String string = this.f20872a.getResources().getString(R.string.skip);
            countDownTextView.setTextSize(0, dimension);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.f20872a.getResources().getDimension(R.dimen.ds106), (int) this.f20872a.getResources().getDimension(R.dimen.ds52));
            countDownTextView.setTextColor(-1);
            countDownTextView.setGravity(17);
            countDownTextView.setAlpha(0.5f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-16777216);
            gradientDrawable.setCornerRadius(this.f20872a.getResources().getDimension(R.dimen.ds4));
            gradientDrawable.setStroke(1, -16777216);
            countDownTextView.setBackgroundDrawable(gradientDrawable);
            countDownTextView.init(string, i2);
            layoutParams.gravity = 53;
            layoutParams.setMargins(0, dimension2, (int) this.f20872a.getResources().getDimension(R.dimen.ds32), 0);
            this.f20873b.addView(countDownTextView, layoutParams);
            countDownTextView.setOnClickListener(new b(this));
            countDownTextView.setTimeoutListener(new c(this));
        }
    }

    public final void e(c.a.e.k.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            ImageView imageView = new ImageView(this.f20872a);
            this.f20874c = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (aVar != null) {
                this.f20874c.setImageBitmap(aVar.p());
            }
            this.f20874c.setOnClickListener(new View$OnClickListenerC0979a(this));
            this.f20873b.addView(this.f20874c);
        }
    }

    public void f(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, obj, i2) == null) {
            if (obj instanceof c.a.e.k.d.a) {
                e((c.a.e.k.d.a) obj);
            }
            c();
            d(i2);
        }
    }
}
