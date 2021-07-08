package com.baidu.swan.games.view.button.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.a.n0.a.a2.e;
import d.a.n0.a.k;
import d.a.n0.a.v2.i;
import d.a.n0.a.v2.n0;
import d.a.n0.a.v2.t;
import d.a.n0.a.z1.a.b;
import d.a.n0.h.o0.d.a.c;
import java.io.File;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class ApiButton extends AppCompatButton implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EventTargetImpl f11913e;

    /* renamed from: f  reason: collision with root package name */
    public String f11914f;

    /* renamed from: g  reason: collision with root package name */
    public String f11915g;

    /* renamed from: h  reason: collision with root package name */
    public String f11916h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f11917i;
    public d.a.n0.h.o0.d.a.a j;
    public int k;
    public int l;

    /* loaded from: classes3.dex */
    public class a extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataSource f11918a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ApiButton f11919b;

        public a(ApiButton apiButton, DataSource dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apiButton, dataSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11919b = apiButton;
            this.f11918a = dataSource;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                if (e.y) {
                    Log.d("ApiButton", "——> onFailureImpl: " + dataSource.getFailureCause().getMessage());
                }
                this.f11919b.j();
                if (dataSource != null) {
                    dataSource.close();
                }
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                if (e.y) {
                    Log.d("ApiButton", "——> onNewResultImpl: ");
                }
                if (this.f11918a.isFinished()) {
                    ApiButton apiButton = this.f11919b;
                    apiButton.f11917i = t.g(bitmap, apiButton.k, this.f11919b.l);
                    this.f11919b.j();
                    this.f11918a.close();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, eventTargetImpl};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11914f = "text";
        this.f11913e = eventTargetImpl;
        setSingleLine();
        setOnClickListener(this);
    }

    private int getTextLineHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? getPaint().getFontMetricsInt().bottom - getPaint().getFontMetricsInt().top : invokeV.intValue;
    }

    private int getTextTopPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? getPaint().getFontMetricsInt().ascent - getPaint().getFontMetricsInt().top : invokeV.intValue;
    }

    private Uri getUri() {
        InterceptResult invokeV;
        String b2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (c.a(this.f11916h) == PathType.NETWORK) {
                return Uri.parse(this.f11916h);
            }
            if (c.a(this.f11916h) != PathType.RELATIVE || (b2 = c.b()) == null) {
                return null;
            }
            if (this.f11916h.startsWith(".")) {
                this.f11916h = this.f11916h.substring(1);
            }
            if (this.f11916h.startsWith("/")) {
                str = b2 + this.f11916h;
            } else {
                str = b2 + File.separator + this.f11916h;
            }
            if (k.f45831a) {
                Log.d("ApiButton", "——> getUri: " + str);
            }
            return Uri.parse(str);
        }
        return (Uri) invokeV.objValue;
    }

    private void setBorder(GradientDrawable gradientDrawable) {
        int g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, gradientDrawable) == null) || (g2 = n0.g(this.j.borderWidth)) <= 0) {
            return;
        }
        gradientDrawable.setStroke(g2, d.a.n0.h.o0.d.a.a.c(m(this.j.borderColor, 0)));
    }

    private void setBorderRadius(GradientDrawable gradientDrawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, gradientDrawable) == null) {
            double d2 = this.j.borderRadius;
            if (d2 != 0.0d) {
                gradientDrawable.setCornerRadius(n0.g((float) d2));
            }
        }
    }

    private void setButtonBackground(GradientDrawable gradientDrawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, gradientDrawable) == null) {
            setBackgroundDrawable(new LayerDrawable(new Drawable[]{l(m(this.j.backgroundColor, 0)), gradientDrawable}));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setTextSize((float) this.j.fontSize);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.j.hidden) {
                setVisibility(8);
            } else {
                setVisibility(0);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            float min = Math.min(1.0f, Math.max(0.0f, (float) this.j.opacity));
            if (getBackground() != null) {
                setAlpha(min);
            }
        }
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f11914f : (String) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.j == null || getParent() == null) {
            return;
        }
        if (p()) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            setBorder(gradientDrawable);
            setBorderRadius(gradientDrawable);
            setButtonBackground(gradientDrawable);
            setText(this.f11915g);
            e();
            setTextColor(m(this.j.color, -16777216));
            s();
            i();
            r();
            g();
        } else {
            q();
        }
        f();
    }

    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.n0.h.o0.d.a.a aVar = this.j;
            if (aVar != null) {
                aVar.hidden = true;
            }
            setVisibility(8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || TextUtils.isEmpty(this.j.textAlign)) {
            return;
        }
        String str = this.j.textAlign;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1364013995) {
            if (hashCode != 3317767) {
                if (hashCode == 108511772 && str.equals("right")) {
                    c2 = 1;
                }
            } else if (str.equals(CustomDialogData.POS_LEFT)) {
                c2 = 0;
            }
        } else if (str.equals("center")) {
            c2 = 2;
        }
        if (c2 == 0) {
            setTextAlignment(5);
        } else if (c2 == 1) {
            setTextAlignment(6);
        } else if (c2 != 2) {
            setTextAlignment(5);
        } else {
            setTextAlignment(4);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.j == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        setBorder(gradientDrawable);
        setBorderRadius(gradientDrawable);
        Object gradientDrawable2 = new GradientDrawable();
        gradientDrawable.setColor(0);
        if (this.f11917i != null) {
            gradientDrawable2 = new b(this.f11917i, n0.g((float) this.j.borderRadius), 0, 0);
        }
        setBackgroundDrawable(new LayerDrawable(new Drawable[]{gradientDrawable2, gradientDrawable}));
        g();
    }

    public void k(JSEvent jSEvent) {
        EventTargetImpl eventTargetImpl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSEvent) == null) || (eventTargetImpl = this.f11913e) == null) {
            return;
        }
        eventTargetImpl.dispatchEvent(jSEvent);
    }

    public final GradientDrawable l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i2);
            int g2 = n0.g(this.j.borderWidth);
            if (g2 > 0) {
                gradientDrawable.setStroke(g2, d.a.n0.h.o0.d.a.a.c(i2));
            }
            double d2 = this.j.borderRadius;
            if (d2 != 0.0d) {
                gradientDrawable.setCornerRadius(n0.g((float) d2));
            }
            return gradientDrawable;
        }
        return (GradientDrawable) invokeI.objValue;
    }

    public final int m(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return i2;
            }
            if (Pattern.compile("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6})$").matcher(str).matches()) {
                return Color.parseColor(str);
            }
            try {
                int parseColor = Color.parseColor(i.b(str));
                return ((parseColor & 255) << 16) | ((parseColor >>> 24) << 24) | (((parseColor >> 8) & 255) << 8) | ((parseColor >> 16) & 255);
            } catch (Exception e2) {
                if (k.f45831a) {
                    e2.printStackTrace();
                    return i2;
                }
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? !p() : invokeV.booleanValue;
    }

    public final boolean o(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, uri)) == null) {
            if (this.f11917i != null) {
                return true;
            }
            if (this.f11916h == null) {
                return false;
            }
            Bitmap c2 = t.c(uri, getContext());
            this.f11917i = c2;
            if (c2 != null) {
                this.f11917i = t.g(c2, this.k, this.l);
            }
            return this.f11917i != null;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048590, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (k.f45831a) {
                Log.d("ApiButton", "onSizeChanged mWidth=" + this.k + ";mHeight" + this.l);
            }
            this.k = i2;
            this.l = i3;
            this.f11917i = null;
            h();
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? TextUtils.equals(getType(), "text") : invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            Uri uri = getUri();
            if (uri != null && !o(uri)) {
                try {
                    t(uri);
                    return;
                } catch (Exception e2) {
                    if (k.f45831a) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            j();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            int g2 = n0.g(this.j.borderWidth);
            int g3 = n0.g(this.j.lineHeight);
            int textLineHeight = g3 > 0 ? ((g3 / 2) - (getTextLineHeight() / 2)) - getTextTopPadding() : 0;
            int max = Math.max(0, g2);
            setPadding(max, Math.max(max, textLineHeight), max, max);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || TextUtils.isEmpty(this.j.fontWeight)) {
            return;
        }
        TextPaint paint = getPaint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        String str = this.j.fontWeight;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1383482894:
                if (str.equals("bolder")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    c2 = 1;
                    break;
                }
                break;
            case 48625:
                if (str.equals("100")) {
                    c2 = 4;
                    break;
                }
                break;
            case 49586:
                if (str.equals("200")) {
                    c2 = 5;
                    break;
                }
                break;
            case 50547:
                if (str.equals("300")) {
                    c2 = 6;
                    break;
                }
                break;
            case 51508:
                if (str.equals(FontParser.sFontWeightDefault)) {
                    c2 = 7;
                    break;
                }
                break;
            case 52469:
                if (str.equals("500")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 53430:
                if (str.equals("600")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 54391:
                if (str.equals("700")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 55352:
                if (str.equals("800")) {
                    c2 = 11;
                    break;
                }
                break;
            case 56313:
                if (str.equals("900")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 3029637:
                if (str.equals("bold")) {
                    c2 = 2;
                    break;
                }
                break;
            case 170546243:
                if (str.equals("lighter")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                paint.setStrokeWidth(0.0f);
                return;
            case 1:
                paint.setStrokeWidth(0.0f);
                return;
            case 2:
                paint.setStrokeWidth(2.0f);
                return;
            case 3:
                paint.setStrokeWidth(3.0f);
                return;
            case 4:
                paint.setStrokeWidth(0.0f);
                return;
            case 5:
                paint.setStrokeWidth(0.0f);
                return;
            case 6:
                paint.setStrokeWidth(0.0f);
                return;
            case 7:
                paint.setStrokeWidth(0.0f);
                return;
            case '\b':
                paint.setStrokeWidth(1.0f);
                return;
            case '\t':
                paint.setStrokeWidth(1.5f);
                return;
            case '\n':
                paint.setStrokeWidth(2.0f);
                return;
            case 11:
                paint.setStrokeWidth(2.5f);
                return;
            case '\f':
                paint.setStrokeWidth(3.0f);
                return;
            default:
                return;
        }
    }

    public void setApiButtonStyle(d.a.n0.h.o0.d.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) {
            this.j = aVar;
        }
    }

    public void setButtonText(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || TextUtils.equals(str, this.f11915g)) {
            return;
        }
        this.f11915g = str;
        if (!p() || getParent() == null) {
            return;
        }
        setText(this.f11915g);
        requestLayout();
    }

    public void setImageUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || TextUtils.equals(str, this.f11916h)) {
            return;
        }
        this.f11916h = str;
        this.f11917i = null;
        if (!n() || getParent() == null) {
            return;
        }
        q();
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.f11914f = str;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            d.a.n0.h.o0.d.a.a aVar = this.j;
            if (aVar != null) {
                aVar.hidden = false;
            }
            setVisibility(0);
        }
    }

    @UiThread
    public final void t(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, uri) == null) {
            DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(uri).build(), getContext());
            fetchDecodedImage.subscribe(new a(this, fetchDecodedImage), UiThreadImmediateExecutorService.getInstance());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiButton(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11914f = "text";
    }
}
