package c.a.c0.d0;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import c.a.c0.d0.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f1889e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float f1890f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ View f1891g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View f1892h;

        public a(Context context, float f2, View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Float.valueOf(f2), view, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1889e = context;
            this.f1890f = f2;
            this.f1891g = view;
            this.f1892h = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                int a = f.c.a(this.f1889e, this.f1890f);
                this.f1891g.getHitRect(rect);
                rect.left -= a;
                rect.right += a;
                rect.top -= a;
                rect.bottom += a;
                this.f1892h.setTouchDelegate(new TouchDelegate(rect, this.f1891g));
            }
        }
    }

    public static void a(Context context, View view, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, view, Float.valueOf(f2)}) == null) || view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (View.class.isInstance(parent)) {
            View view2 = (View) parent;
            view2.post(new a(context, f2, view, view2));
        }
    }

    public static String b(String str, String str2, float f2, TextPaint textPaint) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, Float.valueOf(f2), textPaint})) == null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (textPaint == null) {
                textPaint = new TextPaint();
            }
            CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, f2 - textPaint.measureText(GlideException.IndentedAppendable.INDENT + str2), TextUtils.TruncateAt.END);
            if (TextUtils.isEmpty(ellipsize)) {
                return str2;
            }
            return ellipsize.toString() + GlideException.IndentedAppendable.INDENT + str2;
        }
        return (String) invokeCommon.objValue;
    }
}
