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
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import d.a.l0.a.v2.i;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.t;
import d.a.l0.a.z1.a.b;
import d.a.l0.h.o0.d.a.c;
import java.io.File;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class ApiButton extends AppCompatButton implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public EventTargetImpl f11685e;

    /* renamed from: f  reason: collision with root package name */
    public String f11686f;

    /* renamed from: g  reason: collision with root package name */
    public String f11687g;

    /* renamed from: h  reason: collision with root package name */
    public String f11688h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f11689i;
    public d.a.l0.h.o0.d.a.a j;
    public int k;
    public int l;

    /* loaded from: classes3.dex */
    public class a extends BaseBitmapDataSubscriber {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataSource f11690a;

        public a(DataSource dataSource) {
            this.f11690a = dataSource;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            if (e.y) {
                Log.d("ApiButton", "——> onFailureImpl: " + dataSource.getFailureCause().getMessage());
            }
            ApiButton.this.j();
            if (dataSource != null) {
                dataSource.close();
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            if (e.y) {
                Log.d("ApiButton", "——> onNewResultImpl: ");
            }
            if (this.f11690a.isFinished()) {
                ApiButton apiButton = ApiButton.this;
                apiButton.f11689i = t.g(bitmap, apiButton.k, ApiButton.this.l);
                ApiButton.this.j();
                this.f11690a.close();
            }
        }
    }

    public ApiButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context);
        this.f11686f = "text";
        this.f11685e = eventTargetImpl;
        setSingleLine();
        setOnClickListener(this);
    }

    private int getTextLineHeight() {
        return getPaint().getFontMetricsInt().bottom - getPaint().getFontMetricsInt().top;
    }

    private int getTextTopPadding() {
        return getPaint().getFontMetricsInt().ascent - getPaint().getFontMetricsInt().top;
    }

    private Uri getUri() {
        String b2;
        String str;
        if (c.a(this.f11688h) == PathType.NETWORK) {
            return Uri.parse(this.f11688h);
        }
        if (c.a(this.f11688h) != PathType.RELATIVE || (b2 = c.b()) == null) {
            return null;
        }
        if (this.f11688h.startsWith(".")) {
            this.f11688h = this.f11688h.substring(1);
        }
        if (this.f11688h.startsWith("/")) {
            str = b2 + this.f11688h;
        } else {
            str = b2 + File.separator + this.f11688h;
        }
        if (k.f43199a) {
            Log.d("ApiButton", "——> getUri: " + str);
        }
        return Uri.parse(str);
    }

    private void setBorder(GradientDrawable gradientDrawable) {
        int g2 = n0.g(this.j.borderWidth);
        if (g2 > 0) {
            gradientDrawable.setStroke(g2, d.a.l0.h.o0.d.a.a.c(m(this.j.borderColor, 0)));
        }
    }

    private void setBorderRadius(GradientDrawable gradientDrawable) {
        double d2 = this.j.borderRadius;
        if (d2 != 0.0d) {
            gradientDrawable.setCornerRadius(n0.g((float) d2));
        }
    }

    private void setButtonBackground(GradientDrawable gradientDrawable) {
        setBackgroundDrawable(new LayerDrawable(new Drawable[]{l(m(this.j.backgroundColor, 0)), gradientDrawable}));
    }

    public final void e() {
        setTextSize((float) this.j.fontSize);
    }

    public final void f() {
        if (this.j.hidden) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public final void g() {
        float min = Math.min(1.0f, Math.max(0.0f, (float) this.j.opacity));
        if (getBackground() != null) {
            setAlpha(min);
        }
    }

    public String getType() {
        return this.f11686f;
    }

    public void h() {
        if (this.j == null || getParent() == null) {
            return;
        }
        if (p()) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            setBorder(gradientDrawable);
            setBorderRadius(gradientDrawable);
            setButtonBackground(gradientDrawable);
            setText(this.f11687g);
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
        d.a.l0.h.o0.d.a.a aVar = this.j;
        if (aVar != null) {
            aVar.hidden = true;
        }
        setVisibility(8);
    }

    public final void i() {
        if (TextUtils.isEmpty(this.j.textAlign)) {
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
        if (this.j == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        setBorder(gradientDrawable);
        setBorderRadius(gradientDrawable);
        Object gradientDrawable2 = new GradientDrawable();
        gradientDrawable.setColor(0);
        if (this.f11689i != null) {
            gradientDrawable2 = new b(this.f11689i, n0.g((float) this.j.borderRadius), 0, 0);
        }
        setBackgroundDrawable(new LayerDrawable(new Drawable[]{gradientDrawable2, gradientDrawable}));
        g();
    }

    public void k(JSEvent jSEvent) {
        EventTargetImpl eventTargetImpl = this.f11685e;
        if (eventTargetImpl != null) {
            eventTargetImpl.dispatchEvent(jSEvent);
        }
    }

    public final GradientDrawable l(int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        int g2 = n0.g(this.j.borderWidth);
        if (g2 > 0) {
            gradientDrawable.setStroke(g2, d.a.l0.h.o0.d.a.a.c(i2));
        }
        double d2 = this.j.borderRadius;
        if (d2 != 0.0d) {
            gradientDrawable.setCornerRadius(n0.g((float) d2));
        }
        return gradientDrawable;
    }

    public final int m(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        if (Pattern.compile("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6})$").matcher(str).matches()) {
            return Color.parseColor(str);
        }
        try {
            int parseColor = Color.parseColor(i.b(str));
            int i3 = parseColor >>> 24;
            return ((parseColor & 255) << 16) | (i3 << 24) | (((parseColor >> 8) & 255) << 8) | ((parseColor >> 16) & 255);
        } catch (Exception e2) {
            if (k.f43199a) {
                e2.printStackTrace();
                return i2;
            }
            return i2;
        }
    }

    public boolean n() {
        return !p();
    }

    public final boolean o(Uri uri) {
        if (this.f11689i != null) {
            return true;
        }
        if (this.f11688h == null) {
            return false;
        }
        Bitmap c2 = t.c(uri, getContext());
        this.f11689i = c2;
        if (c2 != null) {
            this.f11689i = t.g(c2, this.k, this.l);
        }
        return this.f11689i != null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (k.f43199a) {
            Log.d("ApiButton", "onSizeChanged mWidth=" + this.k + ";mHeight" + this.l);
        }
        this.k = i2;
        this.l = i3;
        this.f11689i = null;
        h();
    }

    public boolean p() {
        return TextUtils.equals(getType(), "text");
    }

    public final void q() {
        Uri uri = getUri();
        if (uri != null && !o(uri)) {
            try {
                t(uri);
                return;
            } catch (Exception e2) {
                if (k.f43199a) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
        j();
    }

    public final void r() {
        int g2 = n0.g(this.j.borderWidth);
        int g3 = n0.g(this.j.lineHeight);
        int textLineHeight = g3 > 0 ? ((g3 / 2) - (getTextLineHeight() / 2)) - getTextTopPadding() : 0;
        int max = Math.max(0, g2);
        setPadding(max, Math.max(max, textLineHeight), max, max);
    }

    public final void s() {
        if (TextUtils.isEmpty(this.j.fontWeight)) {
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
                if (str.equals(BasicPushStatus.SUCCESS_CODE)) {
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

    public void setApiButtonStyle(d.a.l0.h.o0.d.a.a aVar) {
        this.j = aVar;
    }

    public void setButtonText(String str) {
        if (TextUtils.equals(str, this.f11687g)) {
            return;
        }
        this.f11687g = str;
        if (!p() || getParent() == null) {
            return;
        }
        setText(this.f11687g);
        requestLayout();
    }

    public void setImageUrl(String str) {
        if (TextUtils.equals(str, this.f11688h)) {
            return;
        }
        this.f11688h = str;
        this.f11689i = null;
        if (!n() || getParent() == null) {
            return;
        }
        q();
    }

    public void setType(String str) {
        this.f11686f = str;
    }

    public void show() {
        d.a.l0.h.o0.d.a.a aVar = this.j;
        if (aVar != null) {
            aVar.hidden = false;
        }
        setVisibility(0);
    }

    @UiThread
    public final void t(Uri uri) {
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(uri).build(), getContext());
        fetchDecodedImage.subscribe(new a(fetchDecodedImage), UiThreadImmediateExecutorService.getInstance());
    }

    public ApiButton(Context context) {
        super(context);
        this.f11686f = "text";
    }
}
