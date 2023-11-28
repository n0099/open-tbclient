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
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tieba.d94;
import com.baidu.tieba.ej3;
import com.baidu.tieba.f94;
import com.baidu.tieba.h63;
import com.baidu.tieba.r43;
import com.baidu.tieba.sm1;
import com.baidu.tieba.ti3;
import com.baidu.tieba.yj3;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.io.File;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class ApiButton extends AppCompatButton implements View.OnClickListener {
    public EventTargetImpl a;
    public String b;
    public String c;
    public String d;
    public Bitmap e;
    public d94 f;
    public int g;
    public int h;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    /* loaded from: classes4.dex */
    public class a extends BaseBitmapDataSubscriber {
        public final /* synthetic */ DataSource a;

        public a(DataSource dataSource) {
            this.a = dataSource;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            if (h63.v) {
                Log.d("ApiButton", "——> onFailureImpl: " + dataSource.getFailureCause().getMessage());
            }
            ApiButton.this.l();
            if (dataSource != null) {
                dataSource.close();
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            if (h63.v) {
                Log.d("ApiButton", "——> onNewResultImpl: ");
            }
            if (this.a.isFinished()) {
                ApiButton apiButton = ApiButton.this;
                apiButton.e = ej3.g(bitmap, apiButton.g, ApiButton.this.h);
                ApiButton.this.l();
                this.a.close();
            }
        }
    }

    public ApiButton(Context context) {
        super(context);
        this.b = "text";
    }

    private void setBorder(GradientDrawable gradientDrawable) {
        int g = yj3.g(this.f.borderWidth);
        if (g > 0) {
            gradientDrawable.setStroke(g, d94.c(p(this.f.borderColor, 0)));
        }
    }

    private void setBorderRadius(GradientDrawable gradientDrawable) {
        double d = this.f.borderRadius;
        if (d != 0.0d) {
            gradientDrawable.setCornerRadius(yj3.g((float) d));
        }
    }

    private void setButtonBackground(GradientDrawable gradientDrawable) {
        setBackgroundDrawable(new LayerDrawable(new Drawable[]{o(p(this.f.backgroundColor, 0)), gradientDrawable}));
    }

    @UiThread
    public final void A(Uri uri) {
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(uri).build(), getContext());
        fetchDecodedImage.subscribe(new a(fetchDecodedImage), UiThreadImmediateExecutorService.getInstance());
    }

    public void n(JSEvent jSEvent) {
        EventTargetImpl eventTargetImpl = this.a;
        if (eventTargetImpl != null) {
            eventTargetImpl.dispatchEvent(jSEvent);
        }
    }

    public final GradientDrawable o(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        int g = yj3.g(this.f.borderWidth);
        if (g > 0) {
            gradientDrawable.setStroke(g, d94.c(i));
        }
        double d = this.f.borderRadius;
        if (d != 0.0d) {
            gradientDrawable.setCornerRadius(yj3.g((float) d));
        }
        return gradientDrawable;
    }

    public void setApiButtonStyle(d94 d94Var) {
        this.f = d94Var;
    }

    public void setButtonText(String str) {
        if (TextUtils.equals(str, this.c)) {
            return;
        }
        this.c = str;
        if (u() && getParent() != null) {
            setText(this.c);
            requestLayout();
        }
    }

    public void setImageUrl(String str) {
        if (TextUtils.equals(str, this.d)) {
            return;
        }
        this.d = str;
        this.e = null;
        if (s() && getParent() != null) {
            x();
        }
    }

    public void setType(String str) {
        this.b = str;
    }

    public final boolean t(Uri uri) {
        if (this.e != null) {
            return true;
        }
        if (this.d == null) {
            return false;
        }
        Bitmap c = ej3.c(uri, getContext());
        this.e = c;
        if (c != null) {
            this.e = ej3.g(c, this.g, this.h);
        }
        if (this.e != null) {
            return true;
        }
        return false;
    }

    public ApiButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context);
        this.b = "text";
        this.a = eventTargetImpl;
        setSingleLine();
        setOnClickListener(this);
    }

    private int getTextLineHeight() {
        return getPaint().getFontMetricsInt().bottom - getPaint().getFontMetricsInt().top;
    }

    private int getTextTopPadding() {
        return getPaint().getFontMetricsInt().ascent - getPaint().getFontMetricsInt().top;
    }

    public final void e() {
        setTextSize((float) this.f.fontSize);
    }

    public final void f() {
        if (this.f.hidden) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public final void g() {
        float min = Math.min(1.0f, Math.max(0.0f, (float) this.f.opacity));
        if (getBackground() != null) {
            setAlpha(min);
        }
    }

    public String getType() {
        return this.b;
    }

    public void hide() {
        d94 d94Var = this.f;
        if (d94Var != null) {
            d94Var.hidden = true;
        }
        setVisibility(8);
    }

    public boolean s() {
        return !u();
    }

    public void show() {
        d94 d94Var = this.f;
        if (d94Var != null) {
            d94Var.hidden = false;
        }
        setVisibility(0);
    }

    public boolean u() {
        return TextUtils.equals(getType(), "text");
    }

    public final void x() {
        Uri uri = getUri();
        if (uri != null && !t(uri)) {
            try {
                A(uri);
                return;
            } catch (Exception e) {
                if (sm1.a) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        l();
    }

    public final void y() {
        int i;
        int g = yj3.g(this.f.borderWidth);
        int g2 = yj3.g(this.f.lineHeight);
        if (g2 > 0) {
            i = ((g2 / 2) - (getTextLineHeight() / 2)) - getTextTopPadding();
        } else {
            i = 0;
        }
        int max = Math.max(0, g);
        setPadding(max, Math.max(max, i), max, max);
    }

    private Uri getUri() {
        String b;
        String str;
        if (f94.a(this.d) == PathType.NETWORK) {
            return Uri.parse(this.d);
        }
        if (f94.a(this.d) != PathType.RELATIVE || (b = f94.b()) == null) {
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
        if (sm1.a) {
            Log.d("ApiButton", "——> getUri: " + str);
        }
        return Uri.parse(str);
    }

    public void h() {
        if (this.f != null && getParent() != null) {
            if (u()) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(0);
                setBorder(gradientDrawable);
                setBorderRadius(gradientDrawable);
                setButtonBackground(gradientDrawable);
                setText(this.c);
                e();
                setTextColor(p(this.f.color, -16777216));
                z();
                j();
                y();
                g();
            } else {
                x();
            }
            f();
        }
    }

    public final void j() {
        if (!TextUtils.isEmpty(this.f.textAlign)) {
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
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        setTextAlignment(5);
                        return;
                    } else {
                        setTextAlignment(4);
                        return;
                    }
                }
                setTextAlignment(6);
                return;
            }
            setTextAlignment(5);
        }
    }

    public final void l() {
        if (this.f == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        setBorder(gradientDrawable);
        setBorderRadius(gradientDrawable);
        Object gradientDrawable2 = new GradientDrawable();
        gradientDrawable.setColor(0);
        if (this.e != null) {
            gradientDrawable2 = new r43(this.e, yj3.g((float) this.f.borderRadius), 0, 0);
        }
        setBackgroundDrawable(new LayerDrawable(new Drawable[]{gradientDrawable2, gradientDrawable}));
        g();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (sm1.a) {
            Log.d("ApiButton", "onSizeChanged mWidth=" + this.g + ";mHeight" + this.h);
        }
        this.g = i;
        this.h = i2;
        this.e = null;
        h();
    }

    public final int p(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        if (Pattern.compile("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6})$").matcher(str).matches()) {
            return Color.parseColor(str);
        }
        try {
            int parseColor = Color.parseColor(ti3.b(str));
            int i2 = parseColor >>> 24;
            return ((parseColor & 255) << 16) | (i2 << 24) | (((parseColor >> 8) & 255) << 8) | ((parseColor >> 16) & 255);
        } catch (Exception e) {
            if (sm1.a) {
                e.printStackTrace();
                return i;
            }
            return i;
        }
    }

    public final void z() {
        if (TextUtils.isEmpty(this.f.fontWeight)) {
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
                if (str.equals(YYOption.UrlProtocol.USER)) {
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
}
