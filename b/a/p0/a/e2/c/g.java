package b.a.p0.a.e2.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e2.c.f;
import b.a.p0.a.k;
import b.a.p0.a.p.d.r;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.t;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppScopeDetailActivity;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements r {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public static final int[] m;
    public static final int[] n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f4919a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.a2.e f4920b;

    /* renamed from: c  reason: collision with root package name */
    public DialogInterface.OnClickListener f4921c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.a.e2.c.f f4922d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f4923e;

    /* renamed from: f  reason: collision with root package name */
    public SwanAppAlertDialog.a f4924f;

    /* renamed from: g  reason: collision with root package name */
    public View f4925g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f4926h;

    /* renamed from: i  reason: collision with root package name */
    public View f4927i;
    public TextView j;
    public TextView k;

    /* loaded from: classes.dex */
    public class a implements ActivityResultConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i2, Intent intent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, activityResultDispatcher, i2, intent)) == null) {
                b.a.p0.a.g1.f.T().b();
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends ImageSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g gVar, Drawable drawable) {
            super(drawable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, drawable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Drawable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
                Drawable drawable = getDrawable();
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                canvas.save();
                canvas.translate(f2, ((((fontMetricsInt.descent + i5) + i5) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
                drawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f4928e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f4929f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.e2.c.f f4930g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f4931h;

        public c(g gVar, TextView textView, View view, b.a.p0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, textView, view, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4931h = gVar;
            this.f4928e = textView;
            this.f4929f = view;
            this.f4930g = fVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f4931h.v(!this.f4928e.isEnabled(), this.f4929f, this.f4928e, this.f4930g);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f4932e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f.a f4933f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f4934g;

        public d(g gVar, View view, f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, view, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4934g = gVar;
            this.f4932e = view;
            this.f4933f = aVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f4934g.C(this.f4932e.getContext(), this.f4933f.f4915c);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4935e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4936f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f4937g;

        public e(g gVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4937g = gVar;
            this.f4935e = str;
            this.f4936f = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f4937g.C(b.a.p0.a.a2.d.g().x(), this.f4936f);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        @SuppressLint({"ResourceAsColor"})
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
                textPaint.setColor(Color.parseColor(this.f4935e));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f4938e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f4939f;

        public f(g gVar, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4939f = gVar;
            this.f4938e = textView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                g gVar = this.f4939f;
                gVar.B(gVar.f4922d, this.f4939f.f4926h, this.f4939f.f4925g, this.f4938e, this.f4939f.f4923e, this.f4939f.f4927i);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* renamed from: b.a.p0.a.e2.c.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0168g implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f4940a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppRoundedImageView f4941b;

        public C0168g(g gVar, Context context, SwanAppRoundedImageView swanAppRoundedImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, context, swanAppRoundedImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4940a = context;
            this.f4941b = swanAppRoundedImageView;
        }

        @Override // b.a.p0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    bitmap = BitmapFactory.decodeResource(this.f4940a.getResources(), b.a.p0.a.e.swan_app_user_portrait_pressed);
                }
                SwanAppRoundedImageView swanAppRoundedImageView = this.f4941b;
                if (swanAppRoundedImageView != null) {
                    swanAppRoundedImageView.setImageBitmap(bitmap);
                    this.f4941b.setBorderColor(this.f4940a.getResources().getColor(b.a.p0.a.c.swan_app_auth_icon_border));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h extends ImageSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(g gVar, Drawable drawable) {
            super(drawable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, drawable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Drawable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
                Drawable drawable = getDrawable();
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                canvas.save();
                canvas.translate(f2, ((((fontMetricsInt.descent + i5) + i5) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
                drawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f4942e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f4943f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.e2.c.f f4944g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f4945h;

        public i(g gVar, TextView textView, View view, b.a.p0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, textView, view, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4945h = gVar;
            this.f4942e = textView;
            this.f4943f = view;
            this.f4944g = fVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f4945h.y(!this.f4942e.isEnabled(), this.f4943f, this.f4942e, this.f4944g);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1007968884, "Lb/a/p0/a/e2/c/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1007968884, "Lb/a/p0/a/e2/c/g;");
                return;
            }
        }
        l = k.f6397a;
        m = new int[]{b.a.p0.a.f.agreement_first, b.a.p0.a.f.agreement_second, b.a.p0.a.f.agreement_third, b.a.p0.a.f.agreement_forth};
        n = new int[]{b.a.p0.a.f.agreement_layout_first, b.a.p0.a.f.agreement_layout_second, b.a.p0.a.f.agreement_layout_third, b.a.p0.a.f.agreement_layout_forth};
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void A(Context context, View view, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, view, jSONObject) == null) || context == null || view == null || jSONObject == null) {
            return;
        }
        SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) view.findViewById(b.a.p0.a.f.user_icon);
        TextView textView = (TextView) view.findViewById(b.a.p0.a.f.user_name);
        Pair<String, String> o = o(jSONObject);
        if (o != null) {
            t.e((String) o.second, new C0168g(this, context, swanAppRoundedImageView));
            if (textView != null) {
                textView.setText((CharSequence) o.first);
            }
        }
    }

    public final void B(b.a.p0.a.e2.c.f fVar, TextView textView, View view, TextView textView2, JSONObject jSONObject, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{fVar, textView, view, textView2, jSONObject, view2}) == null) || fVar == null) {
            return;
        }
        String str = fVar.l;
        if (str != null) {
            textView2.setText(Html.fromHtml(str));
        }
        textView.setText(fVar.f4909f);
        ((LinearLayout) view.findViewById(b.a.p0.a.f.permission_detail_layout)).setVisibility(0);
        if (((!TextUtils.equals(fVar.f4905b, "snsapi_userinfo") || jSONObject == null) && !TextUtils.equals(fVar.f4905b, "mobile")) || view2 == null) {
            return;
        }
        view2.findViewById(b.a.p0.a.f.auth_divider1).setVisibility(8);
    }

    public final void C(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) && (context instanceof SwanAppActivity)) {
            SwanAppActivity swanAppActivity = (SwanAppActivity) context;
            ActivityResultDispatcher resultDispatcher = swanAppActivity.getResultDispatcher();
            Intent intent = new Intent(context, SwanAppScopeDetailActivity.class);
            intent.putExtra("url", str);
            resultDispatcher.addConsumer(new a(this));
            b.a.p0.a.g1.f.T().o();
            resultDispatcher.startActivityForResult(intent);
            swanAppActivity.overridePendingTransition(b.a.p0.a.a.aiapps_slide_in_from_right, b.a.p0.a.a.aiapps_hold);
        }
    }

    @Override // b.a.p0.a.p.d.r
    public SwanAppAlertDialog.a a(Context context, b.a.p0.a.a2.e eVar, b.a.p0.a.e2.c.f fVar, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, eVar, fVar, jSONObject, onClickListener)) == null) {
            if (context == null || eVar == null || fVar == null) {
                return null;
            }
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(context);
            this.f4924f = aVar;
            this.f4919a = context;
            this.f4920b = eVar;
            this.f4922d = fVar;
            this.f4923e = jSONObject;
            this.f4921c = onClickListener;
            aVar.f(true);
            this.f4924f.W(n());
            this.f4924f.n(new b.a.p0.a.w2.h.a());
            this.f4924f.p(b.a.p0.a.e.aiapps_action_sheet_bg);
            this.f4924f.k(false);
            this.f4924f.j();
            this.f4924f.t(false);
            return this.f4924f;
        }
        return (SwanAppAlertDialog.a) invokeLLLLL.objValue;
    }

    public final void k() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (frameLayout = (FrameLayout) this.f4925g.findViewById(b.a.p0.a.f.auth_custom_layout)) == null) {
            return;
        }
        this.f4925g.findViewById(b.a.p0.a.f.multi_auth_custom_layout).setVisibility(8);
        this.f4925g.findViewById(b.a.p0.a.f.multi_auth_agreement_layout).setVisibility(8);
        this.f4925g.findViewById(b.a.p0.a.f.auth_custom_layout).setVisibility(0);
        this.f4927i = View.inflate(this.f4919a, b.a.p0.a.g.swan_app_auth_scope_detail, null);
        this.f4922d.f();
        v(false, this.f4927i, this.k, this.f4922d);
        frameLayout.addView(this.f4927i);
    }

    public final void l() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || ((FrameLayout) this.f4925g.findViewById(b.a.p0.a.f.multi_auth_custom_layout)) == null) {
            return;
        }
        this.f4925g.findViewById(b.a.p0.a.f.multi_auth_custom_layout).setVisibility(0);
        this.f4925g.findViewById(b.a.p0.a.f.multi_auth_agreement_layout).setVisibility(0);
        this.f4925g.findViewById(b.a.p0.a.f.auth_custom_layout).setVisibility(8);
        this.f4922d.f();
        y(true, this.f4925g.findViewById(b.a.p0.a.f.auth_scope_detail_layout), this.k, this.f4922d);
        TextView textView = (TextView) this.f4925g.findViewById(b.a.p0.a.f.multi_auth_agreement_layout);
        textView.setVisibility(0);
        f.a aVar = this.f4922d.n;
        String str = aVar.f4917e;
        JSONArray jSONArray = aVar.f4918f;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4919a.getString(b.a.p0.a.h.aiapps_check_action_text));
        if (!TextUtils.isEmpty(aVar.f4916d)) {
            sb.append(aVar.f4916d);
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                String optString = optJSONObject.optString("keyword");
                String optString2 = optJSONObject.optString("detail_url");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && optString.length() <= 17) {
                    sb.append(optString);
                }
            }
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        if (!TextUtils.isEmpty(aVar.f4916d)) {
            z(spannableString, sb, aVar.f4916d, aVar.f4915c, str);
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            int i4 = 0;
            while (i4 < jSONArray.length()) {
                JSONObject optJSONObject2 = jSONArray.optJSONObject(i4);
                String optString3 = optJSONObject2.optString("keyword");
                String optString4 = optJSONObject2.optString("detail_url");
                if (TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4) || optString3.length() > 17) {
                    i2 = i4;
                } else {
                    i2 = i4;
                    z(spannableString, sb, optString3, optString4, str);
                }
                i4 = i2 + 1;
            }
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        textView.setLongClickable(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0069, code lost:
        if (r1.equals("snsapi_userinfo") == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (frameLayout = (FrameLayout) this.f4925g.findViewById(b.a.p0.a.f.auth_custom_layout)) == null) {
            return;
        }
        this.f4925g.findViewById(b.a.p0.a.f.multi_auth_custom_layout).setVisibility(8);
        this.f4925g.findViewById(b.a.p0.a.f.multi_auth_agreement_layout).setVisibility(8);
        char c2 = 0;
        this.f4925g.findViewById(b.a.p0.a.f.auth_custom_layout).setVisibility(0);
        ((TextView) this.f4925g.findViewById(b.a.p0.a.f.multi_auth_agreement_layout)).setVisibility(8);
        this.f4927i = p(this.f4919a, this.f4922d, this.f4923e);
        String str = this.f4922d.f4905b;
        int hashCode = str.hashCode();
        if (hashCode != -1068855134) {
            if (hashCode == -977063690) {
            }
            c2 = 65535;
        } else {
            if (str.equals("mobile")) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            JSONObject jSONObject = this.f4923e;
            if (jSONObject != null) {
                A(this.f4919a, this.f4927i, jSONObject);
            } else {
                x(this.f4927i, this.f4922d);
            }
        } else if (c2 != 1) {
            x(this.f4927i, this.f4922d);
        } else {
            w(this.f4927i, this.f4922d);
        }
        frameLayout.addView(this.f4927i);
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.f4925g = View.inflate(this.f4919a, b.a.p0.a.g.swan_app_auth_dialog_content_common, null);
            q();
            r();
            s();
            return this.f4925g;
        }
        return (View) invokeV.objValue;
    }

    public Pair<String, String> o(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(TableDefine.DB_TABLE_USERINFO);
            if (optJSONObject == null) {
                return null;
            }
            return new Pair<>(optJSONObject.optString("nickname"), optJSONObject.optString("headimgurl"));
        }
        return (Pair) invokeL.objValue;
    }

    public final View p(Context context, b.a.p0.a.e2.c.f fVar, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, context, fVar, jSONObject)) == null) {
            if (context == null || fVar == null || TextUtils.isEmpty(fVar.f4905b)) {
                return null;
            }
            String str = fVar.f4905b;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1068855134) {
                if (hashCode == -977063690 && str.equals("snsapi_userinfo")) {
                    c2 = 0;
                }
            } else if (str.equals("mobile")) {
                c2 = 1;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    i2 = b.a.p0.a.g.swan_app_auth_level2_custom;
                } else {
                    i2 = b.a.p0.a.g.swan_app_auth_level1_mobile_custom;
                }
            } else if (jSONObject != null) {
                i2 = b.a.p0.a.g.swan_app_auth_level1_userinfo_custom;
            } else {
                i2 = b.a.p0.a.g.swan_app_auth_level2_custom;
            }
            return View.inflate(context, i2, null);
        }
        return (View) invokeLLL.objValue;
    }

    public void q() {
        List<b.a.p0.a.e2.c.f> list;
        Bitmap i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean z = (TextUtils.isEmpty(this.f4922d.p) || TextUtils.isEmpty(this.f4922d.q)) ? false : true;
            SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) this.f4925g.findViewById(b.a.p0.a.f.swan_app_icon);
            if (swanAppRoundedImageView != null) {
                if (z) {
                    i2 = q0.j(this.f4922d.q, "SwanAppAuthDialog", false);
                } else {
                    i2 = q0.i(this.f4920b.M(), "SwanAppAuthDialog", false);
                }
                swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(this.f4919a.getResources(), i2));
                swanAppRoundedImageView.setBorderColor(this.f4919a.getResources().getColor(b.a.p0.a.c.swan_app_auth_icon_border));
            }
            ((TextView) this.f4925g.findViewById(b.a.p0.a.f.swan_app_name)).setText(z ? this.f4922d.p : this.f4920b.N());
            TextView textView = (TextView) this.f4925g.findViewById(b.a.p0.a.f.permission_name);
            this.f4926h = textView;
            if (textView != null) {
                if (u(this.f4922d)) {
                    View findViewById = this.f4925g.findViewById(b.a.p0.a.f.swan_app_action_text);
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                    this.f4926h.setText(this.f4922d.r);
                } else {
                    this.f4926h.setText(this.f4922d.f4909f);
                }
            }
            if (u(this.f4922d) && (list = this.f4922d.s) != null && list.size() > 0) {
                for (int i3 = 0; i3 < list.size() && i3 <= 3; i3++) {
                    b.a.p0.a.e2.c.f fVar = list.get(i3);
                    if (fVar != null) {
                        this.f4925g.findViewById(n[i3]).setVisibility(0);
                        ((TextView) this.f4925g.findViewById(m[i3])).setText(fVar.f4910g);
                    }
                }
            }
            this.j = (TextView) this.f4925g.findViewById(b.a.p0.a.f.auth_negative_button);
            this.k = (TextView) this.f4925g.findViewById(b.a.p0.a.f.auth_positive_button);
            this.f4924f.l(this.j, -2, this.f4921c);
            this.f4924f.l(this.k, -1, this.f4921c);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (u(this.f4922d)) {
                l();
            } else if (t(this.f4922d)) {
                k();
            } else {
                m();
            }
        }
    }

    public void s() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || TextUtils.isEmpty(this.f4922d.l) || (textView = (TextView) this.f4925g.findViewById(b.a.p0.a.f.permission_detail)) == null) {
            return;
        }
        b.a.p0.a.a2.e eVar = this.f4920b;
        if (eVar != null && eVar.M() != null && TextUtils.equals(this.f4920b.M().S(), "11010020") && TextUtils.equals(this.f4922d.f4905b, "mobile")) {
            B(this.f4922d, this.f4926h, this.f4925g, textView, this.f4923e, this.f4927i);
            textView.setTextColor(-16777216);
            return;
        }
        if (!u(this.f4922d)) {
            b.a.p0.a.w2.b bVar = new b.a.p0.a.w2.b(this.f4919a, b.a.p0.a.e.swan_app_auth_question_mark_pressed);
            SpannableString spannableString = new SpannableString(" # ");
            spannableString.setSpan(bVar, 1, 2, 33);
            spannableString.setSpan(new f(this, textView), 0, spannableString.length(), 33);
            this.f4926h.append(spannableString);
        }
        this.f4926h.setHighlightColor(0);
        this.f4926h.setMovementMethod(LinkMovementMethod.getInstance());
        this.f4926h.setLongClickable(false);
    }

    public boolean t(b.a.p0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, fVar)) == null) {
            if (fVar == null) {
                return false;
            }
            return TextUtils.equals(fVar.f4905b, "ppcert") || TextUtils.equals(fVar.f4905b, "mapp_i_face_verify");
        }
        return invokeL.booleanValue;
    }

    public boolean u(b.a.p0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, fVar)) == null) {
            if (fVar == null) {
                return false;
            }
            return TextUtils.equals(fVar.f4905b, "scope_multi_authorize");
        }
        return invokeL.booleanValue;
    }

    public final void v(boolean z, View view, TextView textView, b.a.p0.a.e2.c.f fVar) {
        f.a aVar;
        TextView textView2;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), view, textView, fVar}) == null) || view == null || fVar == null || (aVar = fVar.n) == null || (textView2 = (TextView) view.findViewById(b.a.p0.a.f.auth_scope_detail)) == null || TextUtils.isEmpty(aVar.f4913a)) {
            return;
        }
        if (!aVar.f4913a.startsWith("XXXX   ")) {
            aVar.f4913a = "XXXX   " + aVar.f4913a;
        }
        textView2.setText(aVar.f4913a);
        try {
            textView2.setTextColor(Color.parseColor(aVar.f4914b));
        } catch (RuntimeException e2) {
            if (l) {
                throw e2;
            }
        }
        SpannableString spannableString = new SpannableString(textView2.getText());
        textView.setEnabled(z);
        if (z) {
            drawable = view.getResources().getDrawable(b.a.p0.a.e.swanapp_scope_selected);
        } else {
            drawable = view.getResources().getDrawable(b.a.p0.a.e.swanapp_scope_unselected);
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        spannableString.setSpan(new b(this, drawable), 0, 4, 33);
        spannableString.setSpan(new c(this, textView, view, fVar), 0, 7, 33);
        int length = TextUtils.isEmpty(aVar.f4916d) ? 0 : aVar.f4916d.length();
        int indexOf = aVar.f4913a.indexOf(aVar.f4916d);
        int i2 = length + indexOf;
        try {
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(aVar.f4917e)), indexOf, i2, 33);
        } catch (RuntimeException e3) {
            if (l) {
                throw e3;
            }
        }
        spannableString.setSpan(new d(this, view, aVar), indexOf, i2, 33);
        textView2.setText(spannableString);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setHighlightColor(0);
    }

    public final void w(View view, b.a.p0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, view, fVar) == null) || view == null || fVar == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(b.a.p0.a.f.user_phone_number);
        StringBuilder sb = new StringBuilder();
        for (String str : fVar.f4912i) {
            sb.append(str);
        }
        if (textView != null) {
            textView.setText(sb.toString());
        }
    }

    public final void x(View view, b.a.p0.a.e2.c.f fVar) {
        TextView textView;
        SwanAppConfigData r;
        SwanAppConfigData.e eVar;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, view, fVar) == null) || view == null || fVar == null || (textView = (TextView) view.findViewById(b.a.p0.a.f.permission_function)) == null) {
            return;
        }
        if (TextUtils.equals(fVar.f4905b, "mapp_location") && (r = b.a.p0.a.g1.f.T().r()) != null && (eVar = r.o) != null && (map = eVar.f44245a.get("scope.userLocation")) != null) {
            String str = map.get("desc");
            if (!TextUtils.isEmpty(str)) {
                fVar.m = str;
            }
        }
        textView.setText(fVar.m);
    }

    public final void y(boolean z, View view, TextView textView, b.a.p0.a.e2.c.f fVar) {
        TextView textView2;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), view, textView, fVar}) == null) || view == null || fVar == null || fVar.n == null || (textView2 = (TextView) view.findViewById(b.a.p0.a.f.auth_scope_detail)) == null) {
            return;
        }
        textView2.setText("XXXX   " + this.f4919a.getString(b.a.p0.a.h.swanapp_multi_auth_agreement_desc));
        textView.setEnabled(z);
        if (z) {
            drawable = view.getResources().getDrawable(b.a.p0.a.e.swanapp_scope_selected);
        } else {
            drawable = view.getResources().getDrawable(b.a.p0.a.e.swanapp_scope_unselected);
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        h hVar = new h(this, drawable);
        SpannableString spannableString = new SpannableString(textView2.getText());
        spannableString.setSpan(hVar, 0, 4, 33);
        spannableString.setSpan(new i(this, textView, view, fVar), 0, 7, 33);
        textView2.setText(spannableString);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setHighlightColor(0);
    }

    public final void z(SpannableString spannableString, StringBuilder sb, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, spannableString, sb, str, str2, str3) == null) {
            int length = TextUtils.isEmpty(str) ? 0 : str.length();
            int indexOf = sb.indexOf(str);
            int i2 = length + indexOf;
            try {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(str3)), indexOf, i2, 33);
                spannableString.setSpan(new e(this, str3, str2), indexOf, i2, 33);
            } catch (RuntimeException e2) {
                if (l) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
