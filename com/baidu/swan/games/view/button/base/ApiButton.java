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
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.storage.PathType;
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
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.repackage.jh1;
import com.repackage.jz2;
import com.repackage.ld3;
import com.repackage.qe3;
import com.repackage.u34;
import com.repackage.w34;
import com.repackage.wd3;
import com.repackage.z03;
import java.io.File;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class ApiButton extends AppCompatButton implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EventTargetImpl a;
    public String b;
    public String c;
    public String d;
    public Bitmap e;
    public u34 f;
    public int g;
    public int h;

    /* loaded from: classes3.dex */
    public class a extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataSource a;
        public final /* synthetic */ ApiButton b;

        public a(ApiButton apiButton, DataSource dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apiButton, dataSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = apiButton;
            this.a = dataSource;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                if (z03.v) {
                    Log.d("ApiButton", "——> onFailureImpl: " + dataSource.getFailureCause().getMessage());
                }
                this.b.j();
                if (dataSource != null) {
                    dataSource.close();
                }
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                if (z03.v) {
                    Log.d("ApiButton", "——> onNewResultImpl: ");
                }
                if (this.a.isFinished()) {
                    ApiButton apiButton = this.b;
                    apiButton.e = wd3.g(bitmap, apiButton.g, this.b.h);
                    this.b.j();
                    this.a.close();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = "text";
        this.a = eventTargetImpl;
        setSingleLine();
        setOnClickListener(this);
    }

    private int getTextLineHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? getPaint().getFontMetricsInt().bottom - getPaint().getFontMetricsInt().top : invokeV.intValue;
    }

    private int getTextTopPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? getPaint().getFontMetricsInt().ascent - getPaint().getFontMetricsInt().top : invokeV.intValue;
    }

    private Uri getUri() {
        InterceptResult invokeV;
        String b;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (w34.a(this.d) == PathType.NETWORK) {
                return Uri.parse(this.d);
            }
            if (w34.a(this.d) != PathType.RELATIVE || (b = w34.b()) == null) {
                return null;
            }
            if (this.d.startsWith(".")) {
                this.d = this.d.substring(1);
            }
            if (this.d.startsWith("/")) {
                str = b + this.d;
            } else {
                str = b + File.separator + this.d;
            }
            if (jh1.a) {
                Log.d("ApiButton", "——> getUri: " + str);
            }
            return Uri.parse(str);
        }
        return (Uri) invokeV.objValue;
    }

    private void setBorder(GradientDrawable gradientDrawable) {
        int g;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, gradientDrawable) == null) || (g = qe3.g(this.f.borderWidth)) <= 0) {
            return;
        }
        gradientDrawable.setStroke(g, u34.c(m(this.f.borderColor, 0)));
    }

    private void setBorderRadius(GradientDrawable gradientDrawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, gradientDrawable) == null) {
            double d = this.f.borderRadius;
            if (d != 0.0d) {
                gradientDrawable.setCornerRadius(qe3.g((float) d));
            }
        }
    }

    private void setButtonBackground(GradientDrawable gradientDrawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, gradientDrawable) == null) {
            setBackgroundDrawable(new LayerDrawable(new Drawable[]{l(m(this.f.backgroundColor, 0)), gradientDrawable}));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setTextSize((float) this.f.fontSize);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f.hidden) {
                setVisibility(8);
            } else {
                setVisibility(0);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            float min = Math.min(1.0f, Math.max(0.0f, (float) this.f.opacity));
            if (getBackground() != null) {
                setAlpha(min);
            }
        }
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f == null || getParent() == null) {
            return;
        }
        if (p()) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            setBorder(gradientDrawable);
            setBorderRadius(gradientDrawable);
            setButtonBackground(gradientDrawable);
            setText(this.c);
            e();
            setTextColor(m(this.f.color, -16777216));
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
            u34 u34Var = this.f;
            if (u34Var != null) {
                u34Var.hidden = true;
            }
            setVisibility(8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || TextUtils.isEmpty(this.f.textAlign)) {
            return;
        }
        String str = this.f.textAlign;
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1364013995) {
            if (hashCode != 3317767) {
                if (hashCode == 108511772 && str.equals("right")) {
                    c = 1;
                }
            } else if (str.equals("left")) {
                c = 0;
            }
        } else if (str.equals("center")) {
            c = 2;
        }
        if (c == 0) {
            setTextAlignment(5);
        } else if (c == 1) {
            setTextAlignment(6);
        } else if (c != 2) {
            setTextAlignment(5);
        } else {
            setTextAlignment(4);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        setBorder(gradientDrawable);
        setBorderRadius(gradientDrawable);
        Object gradientDrawable2 = new GradientDrawable();
        gradientDrawable.setColor(0);
        if (this.e != null) {
            gradientDrawable2 = new jz2(this.e, qe3.g((float) this.f.borderRadius), 0, 0);
        }
        setBackgroundDrawable(new LayerDrawable(new Drawable[]{gradientDrawable2, gradientDrawable}));
        g();
    }

    public void k(JSEvent jSEvent) {
        EventTargetImpl eventTargetImpl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSEvent) == null) || (eventTargetImpl = this.a) == null) {
            return;
        }
        eventTargetImpl.dispatchEvent(jSEvent);
    }

    public final GradientDrawable l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i);
            int g = qe3.g(this.f.borderWidth);
            if (g > 0) {
                gradientDrawable.setStroke(g, u34.c(i));
            }
            double d = this.f.borderRadius;
            if (d != 0.0d) {
                gradientDrawable.setCornerRadius(qe3.g((float) d));
            }
            return gradientDrawable;
        }
        return (GradientDrawable) invokeI.objValue;
    }

    public final int m(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            if (Pattern.compile("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6})$").matcher(str).matches()) {
                return Color.parseColor(str);
            }
            try {
                int parseColor = Color.parseColor(ld3.b(str));
                return ((parseColor & 255) << 16) | ((parseColor >>> 24) << 24) | (((parseColor >> 8) & 255) << 8) | ((parseColor >> 16) & 255);
            } catch (Exception e) {
                if (jh1.a) {
                    e.printStackTrace();
                    return i;
                }
                return i;
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
            if (this.e != null) {
                return true;
            }
            if (this.d == null) {
                return false;
            }
            Bitmap c = wd3.c(uri, getContext());
            this.e = c;
            if (c != null) {
                this.e = wd3.g(c, this.g, this.h);
            }
            return this.e != null;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048590, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (jh1.a) {
                Log.d("ApiButton", "onSizeChanged mWidth=" + this.g + ";mHeight" + this.h);
            }
            this.g = i;
            this.h = i2;
            this.e = null;
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
                } catch (Exception e) {
                    if (jh1.a) {
                        e.printStackTrace();
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
            int g = qe3.g(this.f.borderWidth);
            int g2 = qe3.g(this.f.lineHeight);
            int textLineHeight = g2 > 0 ? ((g2 / 2) - (getTextLineHeight() / 2)) - getTextTopPadding() : 0;
            int max = Math.max(0, g);
            setPadding(max, Math.max(max, textLineHeight), max, max);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || TextUtils.isEmpty(this.f.fontWeight)) {
            return;
        }
        TextPaint paint = getPaint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        String str = this.f.fontWeight;
        char c = 65535;
        switch (str.hashCode()) {
            case -1383482894:
                if (str.equals("bolder")) {
                    c = 3;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    c = 1;
                    break;
                }
                break;
            case 48625:
                if (str.equals("100")) {
                    c = 4;
                    break;
                }
                break;
            case 49586:
                if (str.equals(BasicPushStatus.SUCCESS_CODE)) {
                    c = 5;
                    break;
                }
                break;
            case 50547:
                if (str.equals(CloudControlRequest.DEFAULT_TIME)) {
                    c = 6;
                    break;
                }
                break;
            case 51508:
                if (str.equals(FontParser.sFontWeightDefault)) {
                    c = 7;
                    break;
                }
                break;
            case 52469:
                if (str.equals("500")) {
                    c = '\b';
                    break;
                }
                break;
            case 53430:
                if (str.equals("600")) {
                    c = '\t';
                    break;
                }
                break;
            case 54391:
                if (str.equals("700")) {
                    c = '\n';
                    break;
                }
                break;
            case 55352:
                if (str.equals("800")) {
                    c = 11;
                    break;
                }
                break;
            case 56313:
                if (str.equals("900")) {
                    c = '\f';
                    break;
                }
                break;
            case 3029637:
                if (str.equals("bold")) {
                    c = 2;
                    break;
                }
                break;
            case 170546243:
                if (str.equals("lighter")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
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

    public void setApiButtonStyle(u34 u34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, u34Var) == null) {
            this.f = u34Var;
        }
    }

    public void setButtonText(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || TextUtils.equals(str, this.c)) {
            return;
        }
        this.c = str;
        if (!p() || getParent() == null) {
            return;
        }
        setText(this.c);
        requestLayout();
    }

    public void setImageUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || TextUtils.equals(str, this.d)) {
            return;
        }
        this.d = str;
        this.e = null;
        if (!n() || getParent() == null) {
            return;
        }
        q();
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.b = str;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            u34 u34Var = this.f;
            if (u34Var != null) {
                u34Var.hidden = false;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = "text";
    }
}
