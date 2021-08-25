package c.a.o0.a.e2.c;

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
import c.a.o0.a.e2.c.f;
import c.a.o0.a.k;
import c.a.o0.a.p.d.r;
import c.a.o0.a.v2.q0;
import c.a.o0.a.v2.t;
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
    public Context f5526a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.a.a2.e f5527b;

    /* renamed from: c  reason: collision with root package name */
    public DialogInterface.OnClickListener f5528c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.a.e2.c.f f5529d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f5530e;

    /* renamed from: f  reason: collision with root package name */
    public SwanAppAlertDialog.a f5531f;

    /* renamed from: g  reason: collision with root package name */
    public View f5532g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f5533h;

    /* renamed from: i  reason: collision with root package name */
    public View f5534i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f5535j;
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
                c.a.o0.a.g1.f.V().b();
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
        public final /* synthetic */ TextView f5536e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f5537f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.e2.c.f f5538g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f5539h;

        public c(g gVar, TextView textView, View view, c.a.o0.a.e2.c.f fVar) {
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
            this.f5539h = gVar;
            this.f5536e = textView;
            this.f5537f = view;
            this.f5538g = fVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5539h.v(!this.f5536e.isEnabled(), this.f5537f, this.f5536e, this.f5538g);
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
        public final /* synthetic */ View f5540e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f.a f5541f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f5542g;

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
            this.f5542g = gVar;
            this.f5540e = view;
            this.f5541f = aVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5542g.C(this.f5540e.getContext(), this.f5541f.f5522c);
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
        public final /* synthetic */ String f5543e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5544f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f5545g;

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
            this.f5545g = gVar;
            this.f5543e = str;
            this.f5544f = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5545g.C(c.a.o0.a.a2.d.g().x(), this.f5544f);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        @SuppressLint({"ResourceAsColor"})
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
                textPaint.setColor(Color.parseColor(this.f5543e));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f5546e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f5547f;

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
            this.f5547f = gVar;
            this.f5546e = textView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                g gVar = this.f5547f;
                gVar.B(gVar.f5529d, this.f5547f.f5533h, this.f5547f.f5532g, this.f5546e, this.f5547f.f5530e, this.f5547f.f5534i);
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

    /* renamed from: c.a.o0.a.e2.c.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0171g implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f5548a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppRoundedImageView f5549b;

        public C0171g(g gVar, Context context, SwanAppRoundedImageView swanAppRoundedImageView) {
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
            this.f5548a = context;
            this.f5549b = swanAppRoundedImageView;
        }

        @Override // c.a.o0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    bitmap = BitmapFactory.decodeResource(this.f5548a.getResources(), c.a.o0.a.e.swan_app_user_portrait_pressed);
                }
                SwanAppRoundedImageView swanAppRoundedImageView = this.f5549b;
                if (swanAppRoundedImageView != null) {
                    swanAppRoundedImageView.setImageBitmap(bitmap);
                    this.f5549b.setBorderColor(this.f5548a.getResources().getColor(c.a.o0.a.c.swan_app_auth_icon_border));
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
        public final /* synthetic */ TextView f5550e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f5551f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.e2.c.f f5552g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f5553h;

        public i(g gVar, TextView textView, View view, c.a.o0.a.e2.c.f fVar) {
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
            this.f5553h = gVar;
            this.f5550e = textView;
            this.f5551f = view;
            this.f5552g = fVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5553h.y(!this.f5550e.isEnabled(), this.f5551f, this.f5550e, this.f5552g);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1647585780, "Lc/a/o0/a/e2/c/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1647585780, "Lc/a/o0/a/e2/c/g;");
                return;
            }
        }
        l = k.f7049a;
        m = new int[]{c.a.o0.a.f.agreement_first, c.a.o0.a.f.agreement_second, c.a.o0.a.f.agreement_third, c.a.o0.a.f.agreement_forth};
        n = new int[]{c.a.o0.a.f.agreement_layout_first, c.a.o0.a.f.agreement_layout_second, c.a.o0.a.f.agreement_layout_third, c.a.o0.a.f.agreement_layout_forth};
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
        SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) view.findViewById(c.a.o0.a.f.user_icon);
        TextView textView = (TextView) view.findViewById(c.a.o0.a.f.user_name);
        Pair<String, String> o = o(jSONObject);
        if (o != null) {
            t.e((String) o.second, new C0171g(this, context, swanAppRoundedImageView));
            if (textView != null) {
                textView.setText((CharSequence) o.first);
            }
        }
    }

    public final void B(c.a.o0.a.e2.c.f fVar, TextView textView, View view, TextView textView2, JSONObject jSONObject, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{fVar, textView, view, textView2, jSONObject, view2}) == null) || fVar == null) {
            return;
        }
        String str = fVar.l;
        if (str != null) {
            textView2.setText(Html.fromHtml(str));
        }
        textView.setText(fVar.f5515f);
        ((LinearLayout) view.findViewById(c.a.o0.a.f.permission_detail_layout)).setVisibility(0);
        if (((!TextUtils.equals(fVar.f5511b, "snsapi_userinfo") || jSONObject == null) && !TextUtils.equals(fVar.f5511b, "mobile")) || view2 == null) {
            return;
        }
        view2.findViewById(c.a.o0.a.f.auth_divider1).setVisibility(8);
    }

    public final void C(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) && (context instanceof SwanAppActivity)) {
            SwanAppActivity swanAppActivity = (SwanAppActivity) context;
            ActivityResultDispatcher resultDispatcher = swanAppActivity.getResultDispatcher();
            Intent intent = new Intent(context, SwanAppScopeDetailActivity.class);
            intent.putExtra("url", str);
            resultDispatcher.addConsumer(new a(this));
            c.a.o0.a.g1.f.V().p();
            resultDispatcher.startActivityForResult(intent);
            swanAppActivity.overridePendingTransition(c.a.o0.a.a.aiapps_slide_in_from_right, c.a.o0.a.a.aiapps_hold);
        }
    }

    @Override // c.a.o0.a.p.d.r
    public SwanAppAlertDialog.a a(Context context, c.a.o0.a.a2.e eVar, c.a.o0.a.e2.c.f fVar, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, eVar, fVar, jSONObject, onClickListener)) == null) {
            if (context == null || eVar == null || fVar == null) {
                return null;
            }
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(context);
            this.f5531f = aVar;
            this.f5526a = context;
            this.f5527b = eVar;
            this.f5529d = fVar;
            this.f5530e = jSONObject;
            this.f5528c = onClickListener;
            aVar.f(true);
            this.f5531f.W(n());
            this.f5531f.n(new c.a.o0.a.w2.h.a());
            this.f5531f.p(c.a.o0.a.e.aiapps_action_sheet_bg);
            this.f5531f.k(false);
            this.f5531f.j();
            this.f5531f.t(false);
            return this.f5531f;
        }
        return (SwanAppAlertDialog.a) invokeLLLLL.objValue;
    }

    public final void k() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (frameLayout = (FrameLayout) this.f5532g.findViewById(c.a.o0.a.f.auth_custom_layout)) == null) {
            return;
        }
        this.f5532g.findViewById(c.a.o0.a.f.multi_auth_custom_layout).setVisibility(8);
        this.f5532g.findViewById(c.a.o0.a.f.multi_auth_agreement_layout).setVisibility(8);
        this.f5532g.findViewById(c.a.o0.a.f.auth_custom_layout).setVisibility(0);
        this.f5534i = View.inflate(this.f5526a, c.a.o0.a.g.swan_app_auth_scope_detail, null);
        this.f5529d.f();
        v(false, this.f5534i, this.k, this.f5529d);
        frameLayout.addView(this.f5534i);
    }

    public final void l() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || ((FrameLayout) this.f5532g.findViewById(c.a.o0.a.f.multi_auth_custom_layout)) == null) {
            return;
        }
        this.f5532g.findViewById(c.a.o0.a.f.multi_auth_custom_layout).setVisibility(0);
        this.f5532g.findViewById(c.a.o0.a.f.multi_auth_agreement_layout).setVisibility(0);
        this.f5532g.findViewById(c.a.o0.a.f.auth_custom_layout).setVisibility(8);
        this.f5529d.f();
        y(true, this.f5532g.findViewById(c.a.o0.a.f.auth_scope_detail_layout), this.k, this.f5529d);
        TextView textView = (TextView) this.f5532g.findViewById(c.a.o0.a.f.multi_auth_agreement_layout);
        textView.setVisibility(0);
        f.a aVar = this.f5529d.n;
        String str = aVar.f5524e;
        JSONArray jSONArray = aVar.f5525f;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5526a.getString(c.a.o0.a.h.aiapps_check_action_text));
        if (!TextUtils.isEmpty(aVar.f5523d)) {
            sb.append(aVar.f5523d);
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
        if (!TextUtils.isEmpty(aVar.f5523d)) {
            z(spannableString, sb, aVar.f5523d, aVar.f5522c, str);
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
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (frameLayout = (FrameLayout) this.f5532g.findViewById(c.a.o0.a.f.auth_custom_layout)) == null) {
            return;
        }
        this.f5532g.findViewById(c.a.o0.a.f.multi_auth_custom_layout).setVisibility(8);
        this.f5532g.findViewById(c.a.o0.a.f.multi_auth_agreement_layout).setVisibility(8);
        char c2 = 0;
        this.f5532g.findViewById(c.a.o0.a.f.auth_custom_layout).setVisibility(0);
        ((TextView) this.f5532g.findViewById(c.a.o0.a.f.multi_auth_agreement_layout)).setVisibility(8);
        this.f5534i = p(this.f5526a, this.f5529d, this.f5530e);
        String str = this.f5529d.f5511b;
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
            JSONObject jSONObject = this.f5530e;
            if (jSONObject != null) {
                A(this.f5526a, this.f5534i, jSONObject);
            } else {
                x(this.f5534i, this.f5529d);
            }
        } else if (c2 != 1) {
            x(this.f5534i, this.f5529d);
        } else {
            w(this.f5534i, this.f5529d);
        }
        frameLayout.addView(this.f5534i);
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.f5532g = View.inflate(this.f5526a, c.a.o0.a.g.swan_app_auth_dialog_content_common, null);
            q();
            r();
            s();
            return this.f5532g;
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

    public final View p(Context context, c.a.o0.a.e2.c.f fVar, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, context, fVar, jSONObject)) == null) {
            if (context == null || fVar == null || TextUtils.isEmpty(fVar.f5511b)) {
                return null;
            }
            String str = fVar.f5511b;
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
                    i2 = c.a.o0.a.g.swan_app_auth_level2_custom;
                } else {
                    i2 = c.a.o0.a.g.swan_app_auth_level1_mobile_custom;
                }
            } else if (jSONObject != null) {
                i2 = c.a.o0.a.g.swan_app_auth_level1_userinfo_custom;
            } else {
                i2 = c.a.o0.a.g.swan_app_auth_level2_custom;
            }
            return View.inflate(context, i2, null);
        }
        return (View) invokeLLL.objValue;
    }

    public void q() {
        List<c.a.o0.a.e2.c.f> list;
        Bitmap i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean z = (TextUtils.isEmpty(this.f5529d.p) || TextUtils.isEmpty(this.f5529d.q)) ? false : true;
            SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) this.f5532g.findViewById(c.a.o0.a.f.swan_app_icon);
            if (swanAppRoundedImageView != null) {
                if (z) {
                    i2 = q0.j(this.f5529d.q, "SwanAppAuthDialog", false);
                } else {
                    i2 = q0.i(this.f5527b.N(), "SwanAppAuthDialog", false);
                }
                swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(this.f5526a.getResources(), i2));
                swanAppRoundedImageView.setBorderColor(this.f5526a.getResources().getColor(c.a.o0.a.c.swan_app_auth_icon_border));
            }
            ((TextView) this.f5532g.findViewById(c.a.o0.a.f.swan_app_name)).setText(z ? this.f5529d.p : this.f5527b.O());
            TextView textView = (TextView) this.f5532g.findViewById(c.a.o0.a.f.permission_name);
            this.f5533h = textView;
            if (textView != null) {
                if (u(this.f5529d)) {
                    View findViewById = this.f5532g.findViewById(c.a.o0.a.f.swan_app_action_text);
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                    this.f5533h.setText(this.f5529d.r);
                } else {
                    this.f5533h.setText(this.f5529d.f5515f);
                }
            }
            if (u(this.f5529d) && (list = this.f5529d.s) != null && list.size() > 0) {
                for (int i3 = 0; i3 < list.size() && i3 <= 3; i3++) {
                    c.a.o0.a.e2.c.f fVar = list.get(i3);
                    if (fVar != null) {
                        this.f5532g.findViewById(n[i3]).setVisibility(0);
                        ((TextView) this.f5532g.findViewById(m[i3])).setText(fVar.f5516g);
                    }
                }
            }
            this.f5535j = (TextView) this.f5532g.findViewById(c.a.o0.a.f.auth_negative_button);
            this.k = (TextView) this.f5532g.findViewById(c.a.o0.a.f.auth_positive_button);
            this.f5531f.l(this.f5535j, -2, this.f5528c);
            this.f5531f.l(this.k, -1, this.f5528c);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (u(this.f5529d)) {
                l();
            } else if (t(this.f5529d)) {
                k();
            } else {
                m();
            }
        }
    }

    public void s() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || TextUtils.isEmpty(this.f5529d.l) || (textView = (TextView) this.f5532g.findViewById(c.a.o0.a.f.permission_detail)) == null) {
            return;
        }
        c.a.o0.a.a2.e eVar = this.f5527b;
        if (eVar != null && eVar.N() != null && TextUtils.equals(this.f5527b.N().T(), "11010020") && TextUtils.equals(this.f5529d.f5511b, "mobile")) {
            B(this.f5529d, this.f5533h, this.f5532g, textView, this.f5530e, this.f5534i);
            textView.setTextColor(-16777216);
            return;
        }
        if (!u(this.f5529d)) {
            c.a.o0.a.w2.b bVar = new c.a.o0.a.w2.b(this.f5526a, c.a.o0.a.e.swan_app_auth_question_mark_pressed);
            SpannableString spannableString = new SpannableString(" # ");
            spannableString.setSpan(bVar, 1, 2, 33);
            spannableString.setSpan(new f(this, textView), 0, spannableString.length(), 33);
            this.f5533h.append(spannableString);
        }
        this.f5533h.setHighlightColor(0);
        this.f5533h.setMovementMethod(LinkMovementMethod.getInstance());
        this.f5533h.setLongClickable(false);
    }

    public boolean t(c.a.o0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, fVar)) == null) {
            if (fVar == null) {
                return false;
            }
            return TextUtils.equals(fVar.f5511b, "ppcert") || TextUtils.equals(fVar.f5511b, "mapp_i_face_verify");
        }
        return invokeL.booleanValue;
    }

    public boolean u(c.a.o0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, fVar)) == null) {
            if (fVar == null) {
                return false;
            }
            return TextUtils.equals(fVar.f5511b, "scope_multi_authorize");
        }
        return invokeL.booleanValue;
    }

    public final void v(boolean z, View view, TextView textView, c.a.o0.a.e2.c.f fVar) {
        f.a aVar;
        TextView textView2;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), view, textView, fVar}) == null) || view == null || fVar == null || (aVar = fVar.n) == null || (textView2 = (TextView) view.findViewById(c.a.o0.a.f.auth_scope_detail)) == null || TextUtils.isEmpty(aVar.f5520a)) {
            return;
        }
        if (!aVar.f5520a.startsWith("XXXX   ")) {
            aVar.f5520a = "XXXX   " + aVar.f5520a;
        }
        textView2.setText(aVar.f5520a);
        try {
            textView2.setTextColor(Color.parseColor(aVar.f5521b));
        } catch (RuntimeException e2) {
            if (l) {
                throw e2;
            }
        }
        SpannableString spannableString = new SpannableString(textView2.getText());
        textView.setEnabled(z);
        if (z) {
            drawable = view.getResources().getDrawable(c.a.o0.a.e.swanapp_scope_selected);
        } else {
            drawable = view.getResources().getDrawable(c.a.o0.a.e.swanapp_scope_unselected);
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        spannableString.setSpan(new b(this, drawable), 0, 4, 33);
        spannableString.setSpan(new c(this, textView, view, fVar), 0, 7, 33);
        int length = TextUtils.isEmpty(aVar.f5523d) ? 0 : aVar.f5523d.length();
        int indexOf = aVar.f5520a.indexOf(aVar.f5523d);
        int i2 = length + indexOf;
        try {
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(aVar.f5524e)), indexOf, i2, 33);
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

    public final void w(View view, c.a.o0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, view, fVar) == null) || view == null || fVar == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(c.a.o0.a.f.user_phone_number);
        StringBuilder sb = new StringBuilder();
        for (String str : fVar.f5518i) {
            sb.append(str);
        }
        if (textView != null) {
            textView.setText(sb.toString());
        }
    }

    public final void x(View view, c.a.o0.a.e2.c.f fVar) {
        TextView textView;
        SwanAppConfigData s;
        SwanAppConfigData.e eVar;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, view, fVar) == null) || view == null || fVar == null || (textView = (TextView) view.findViewById(c.a.o0.a.f.permission_function)) == null) {
            return;
        }
        if (TextUtils.equals(fVar.f5511b, "mapp_location") && (s = c.a.o0.a.g1.f.V().s()) != null && (eVar = s.o) != null && (map = eVar.f46456a.get("scope.userLocation")) != null) {
            String str = map.get("desc");
            if (!TextUtils.isEmpty(str)) {
                fVar.m = str;
            }
        }
        textView.setText(fVar.m);
    }

    public final void y(boolean z, View view, TextView textView, c.a.o0.a.e2.c.f fVar) {
        TextView textView2;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), view, textView, fVar}) == null) || view == null || fVar == null || fVar.n == null || (textView2 = (TextView) view.findViewById(c.a.o0.a.f.auth_scope_detail)) == null) {
            return;
        }
        textView2.setText("XXXX   " + this.f5526a.getString(c.a.o0.a.h.swanapp_multi_auth_agreement_desc));
        textView.setEnabled(z);
        if (z) {
            drawable = view.getResources().getDrawable(c.a.o0.a.e.swanapp_scope_selected);
        } else {
            drawable = view.getResources().getDrawable(c.a.o0.a.e.swanapp_scope_unselected);
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
