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
import d.b.h0.a.i2.h;
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.s;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import d.b.h0.g.k0.f.a.c;
import java.io.File;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class ApiButton extends AppCompatButton implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public EventTargetImpl f12549e;

    /* renamed from: f  reason: collision with root package name */
    public String f12550f;

    /* renamed from: g  reason: collision with root package name */
    public String f12551g;

    /* renamed from: h  reason: collision with root package name */
    public String f12552h;
    public Bitmap i;
    public d.b.h0.g.k0.f.a.a j;
    public int k;
    public int l;

    /* loaded from: classes3.dex */
    public class a extends BaseBitmapDataSubscriber {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataSource f12553a;

        public a(DataSource dataSource) {
            this.f12553a = dataSource;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            if (e.x) {
                Log.d("ApiButton", "——> onFailureImpl: " + dataSource.getFailureCause().getMessage());
            }
            ApiButton.this.k();
            if (dataSource != null) {
                dataSource.close();
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            if (e.x) {
                Log.d("ApiButton", "——> onNewResultImpl: ");
            }
            if (this.f12553a.isFinished()) {
                ApiButton apiButton = ApiButton.this;
                apiButton.i = s.g(bitmap, apiButton.k, ApiButton.this.l);
                ApiButton.this.k();
                this.f12553a.close();
            }
        }
    }

    public ApiButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context);
        this.f12550f = "text";
        this.f12549e = eventTargetImpl;
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
        if (c.a(this.f12552h) == PathType.NETWORK) {
            return Uri.parse(this.f12552h);
        }
        if (c.a(this.f12552h) != PathType.RELATIVE || (b2 = c.b()) == null) {
            return null;
        }
        if (this.f12552h.startsWith(".")) {
            this.f12552h = this.f12552h.substring(1);
        }
        if (this.f12552h.startsWith("/")) {
            str = b2 + this.f12552h;
        } else {
            str = b2 + File.separator + this.f12552h;
        }
        if (k.f45772a) {
            Log.d("ApiButton", "——> getUri: " + str);
        }
        return Uri.parse(str);
    }

    private void setBorder(GradientDrawable gradientDrawable) {
        int f2 = h0.f(this.j.borderWidth);
        if (f2 > 0) {
            gradientDrawable.setStroke(f2, d.b.h0.g.k0.f.a.a.c(n(this.j.borderColor, 0)));
        }
    }

    private void setBorderRadius(GradientDrawable gradientDrawable) {
        double d2 = this.j.borderRadius;
        if (d2 != 0.0d) {
            gradientDrawable.setCornerRadius(h0.f((float) d2));
        }
    }

    private void setButtonBackground(GradientDrawable gradientDrawable) {
        setBackgroundDrawable(new LayerDrawable(new Drawable[]{m(n(this.j.backgroundColor, 0)), gradientDrawable}));
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

    public String getType() {
        return this.f12550f;
    }

    public final void h() {
        float min = Math.min(1.0f, Math.max(0.0f, (float) this.j.opacity));
        if (getBackground() != null) {
            setAlpha(min);
        }
    }

    public void i() {
        if (this.j == null || getParent() == null) {
            return;
        }
        if (r()) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            setBorder(gradientDrawable);
            setBorderRadius(gradientDrawable);
            setButtonBackground(gradientDrawable);
            setText(this.f12551g);
            e();
            setTextColor(n(this.j.color, -16777216));
            v();
            j();
            u();
            h();
        } else {
            s();
        }
        f();
    }

    public final void j() {
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

    public final void k() {
        if (this.j == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        setBorder(gradientDrawable);
        setBorderRadius(gradientDrawable);
        Object gradientDrawable2 = new GradientDrawable();
        gradientDrawable.setColor(0);
        if (this.i != null) {
            gradientDrawable2 = new d.b.h0.a.q1.a.c(this.i, h0.f((float) this.j.borderRadius), 0, 0);
        }
        setBackgroundDrawable(new LayerDrawable(new Drawable[]{gradientDrawable2, gradientDrawable}));
        h();
    }

    public void l(JSEvent jSEvent) {
        EventTargetImpl eventTargetImpl = this.f12549e;
        if (eventTargetImpl != null) {
            eventTargetImpl.dispatchEvent(jSEvent);
        }
    }

    public final GradientDrawable m(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        int f2 = h0.f(this.j.borderWidth);
        if (f2 > 0) {
            gradientDrawable.setStroke(f2, d.b.h0.g.k0.f.a.a.c(i));
        }
        double d2 = this.j.borderRadius;
        if (d2 != 0.0d) {
            gradientDrawable.setCornerRadius(h0.f((float) d2));
        }
        return gradientDrawable;
    }

    public final int n(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        if (Pattern.compile("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6})$").matcher(str).matches()) {
            return Color.parseColor(str);
        }
        try {
            int parseColor = Color.parseColor(h.b(str));
            int i2 = parseColor >>> 24;
            return ((parseColor & 255) << 16) | (i2 << 24) | (((parseColor >> 8) & 255) << 8) | ((parseColor >> 16) & 255);
        } catch (Exception e2) {
            if (k.f45772a) {
                e2.printStackTrace();
                return i;
            }
            return i;
        }
    }

    public void o() {
        d.b.h0.g.k0.f.a.a aVar = this.j;
        if (aVar != null) {
            aVar.hidden = true;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (k.f45772a) {
            Log.d("ApiButton", "onSizeChanged mWidth=" + this.k + ";mHeight" + this.l);
        }
        this.k = i;
        this.l = i2;
        this.i = null;
        i();
    }

    public boolean p() {
        return !r();
    }

    public final boolean q(Uri uri) {
        if (this.i != null) {
            return true;
        }
        if (this.f12552h == null) {
            return false;
        }
        Bitmap c2 = s.c(uri, getContext());
        this.i = c2;
        if (c2 != null) {
            this.i = s.g(c2, this.k, this.l);
        }
        return this.i != null;
    }

    public boolean r() {
        return TextUtils.equals(getType(), "text");
    }

    public final void s() {
        Uri uri = getUri();
        if (uri != null && !q(uri)) {
            try {
                x(uri);
                return;
            } catch (Exception e2) {
                if (k.f45772a) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
        k();
    }

    public void setApiButtonStyle(d.b.h0.g.k0.f.a.a aVar) {
        this.j = aVar;
    }

    public void setButtonText(String str) {
        if (TextUtils.equals(str, this.f12551g)) {
            return;
        }
        this.f12551g = str;
        if (!r() || getParent() == null) {
            return;
        }
        setText(this.f12551g);
        requestLayout();
    }

    public void setImageUrl(String str) {
        if (TextUtils.equals(str, this.f12552h)) {
            return;
        }
        this.f12552h = str;
        this.i = null;
        if (!p() || getParent() == null) {
            return;
        }
        s();
    }

    public void setType(String str) {
        this.f12550f = str;
    }

    public final void u() {
        int f2 = h0.f(this.j.borderWidth);
        int f3 = h0.f(this.j.lineHeight);
        int textLineHeight = f3 > 0 ? ((f3 / 2) - (getTextLineHeight() / 2)) - getTextTopPadding() : 0;
        int max = Math.max(0, f2);
        setPadding(max, Math.max(max, textLineHeight), max, max);
    }

    public final void v() {
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

    public void w() {
        d.b.h0.g.k0.f.a.a aVar = this.j;
        if (aVar != null) {
            aVar.hidden = false;
        }
        setVisibility(0);
    }

    @UiThread
    public final void x(Uri uri) {
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(uri).build(), getContext());
        fetchDecodedImage.subscribe(new a(fetchDecodedImage), UiThreadImmediateExecutorService.getInstance());
    }

    public ApiButton(Context context) {
        super(context);
        this.f12550f = "text";
    }
}
