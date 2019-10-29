package com.baidu.swan.games.view.button.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatButton;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.an.m;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.storage.PathType;
import com.facebook.common.b.f;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.io.File;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class ApiButton extends AppCompatButton implements View.OnClickListener {
    private EventTargetImpl bEZ;
    private String bFa;
    private a bFb;
    private Bitmap mBitmap;
    private int mHeight;
    private String mText;
    private String mType;
    private int mWidth;

    public ApiButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context);
        this.mType = "text";
        this.bEZ = eventTargetImpl;
        setSingleLine();
        setOnClickListener(this);
    }

    public ApiButton(Context context) {
        super(context);
        this.mType = "text";
    }

    public void hide() {
        if (this.bFb != null) {
            this.bFb.hidden = true;
        }
        setVisibility(8);
    }

    public void show() {
        if (this.bFb != null) {
            this.bFb.hidden = false;
        }
        setVisibility(0);
    }

    public void setApiButtonStyle(a aVar) {
        this.bFb = aVar;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setButtonText(String str) {
        if (!TextUtils.equals(str, this.mText)) {
            this.mText = str;
            if (nn() && getParent() != null) {
                setText(this.mText);
                requestLayout();
            }
        }
    }

    public void setImageUrl(String str) {
        if (!TextUtils.equals(str, this.bFa)) {
            this.bFa = str;
            this.mBitmap = null;
            if (YI() && getParent() != null) {
                wy();
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("ApiButton", "onSizeChanged mWidth=" + this.mWidth + ";mHeight" + this.mHeight);
        }
        this.mWidth = i;
        this.mHeight = i2;
        this.mBitmap = null;
        YA();
    }

    public void YA() {
        if (this.bFb != null && getParent() != null) {
            if (nn()) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(0);
                setBorder(gradientDrawable);
                setBorderRadius(gradientDrawable);
                setButtonBackground(gradientDrawable);
                setText(this.mText);
                YB();
                setTextColor(H(this.bFb.color, ViewCompat.MEASURED_STATE_MASK));
                YE();
                YD();
                YF();
                YH();
            } else {
                wy();
            }
            YC();
        }
    }

    private void setButtonBackground(GradientDrawable gradientDrawable) {
        setBackgroundDrawable(new LayerDrawable(new Drawable[]{ge(H(this.bFb.backgroundColor, 0)), gradientDrawable}));
    }

    private GradientDrawable ge(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        int S = z.S(this.bFb.borderWidth);
        if (S > 0) {
            gradientDrawable.setStroke(S, a.gf(i));
        }
        if (this.bFb.borderRadius != 0.0d) {
            gradientDrawable.setCornerRadius(z.S((float) this.bFb.borderRadius));
        }
        return gradientDrawable;
    }

    private int H(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (Pattern.compile("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6})$").matcher(str).matches()) {
                return Color.parseColor(str);
            }
            try {
                int parseColor = Color.parseColor(com.baidu.swan.apps.an.d.toColorRGBA(str));
                int i2 = parseColor >>> 24;
                return ((parseColor & 255) << 16) | (i2 << 24) | (((parseColor >> 8) & 255) << 8) | ((parseColor >> 16) & 255);
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                    return i;
                }
                return i;
            }
        }
        return i;
    }

    private void YB() {
        setTextSize((float) this.bFb.fontSize);
    }

    private void YC() {
        if (this.bFb.hidden) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    private void wy() {
        Uri uri = getUri();
        if (uri == null || i(uri)) {
            YG();
            return;
        }
        try {
            j(uri);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private Uri getUri() {
        String YN;
        String str;
        if (d.im(this.bFa) == PathType.NETWORK) {
            return Uri.parse(this.bFa);
        }
        if (d.im(this.bFa) != PathType.RELATIVE || (YN = d.YN()) == null) {
            return null;
        }
        if (this.bFa.startsWith(DefaultConfig.TOKEN_SEPARATOR)) {
            this.bFa = this.bFa.substring(1);
        }
        if (this.bFa.startsWith("/")) {
            str = YN + this.bFa;
        } else {
            str = YN + File.separator + this.bFa;
        }
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("ApiButton", "——> getUri: " + str);
        }
        return Uri.parse(str);
    }

    private void YD() {
        if (!TextUtils.isEmpty(this.bFb.textAlign)) {
            String str = this.bFb.textAlign;
            char c = 65535;
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        c = 0;
                        break;
                    }
                    break;
                case 108511772:
                    if (str.equals(HorizontalTranslateLayout.RIGHT)) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    setTextAlignment(5);
                    return;
                case 1:
                    setTextAlignment(6);
                    return;
                case 2:
                    setTextAlignment(4);
                    return;
                default:
                    setTextAlignment(5);
                    return;
            }
        }
    }

    private void YE() {
        if (!TextUtils.isEmpty(this.bFb.fontWeight)) {
            TextPaint paint = getPaint();
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            String str = this.bFb.fontWeight;
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
                    if (str.equals("300")) {
                        c = 6;
                        break;
                    }
                    break;
                case 51508:
                    if (str.equals("400")) {
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

    private void setBorderRadius(GradientDrawable gradientDrawable) {
        if (this.bFb.borderRadius != 0.0d) {
            gradientDrawable.setCornerRadius(z.S((float) this.bFb.borderRadius));
        }
    }

    private void setBorder(GradientDrawable gradientDrawable) {
        int S = z.S(this.bFb.borderWidth);
        if (S > 0) {
            gradientDrawable.setStroke(S, a.gf(H(this.bFb.borderColor, 0)));
        }
    }

    private void YF() {
        int S = z.S(this.bFb.borderWidth);
        int S2 = z.S(this.bFb.lineHeight);
        int textLineHeight = S2 > 0 ? ((S2 / 2) - (getTextLineHeight() / 2)) - getTextTopPadding() : 0;
        int max = Math.max(0, S);
        setPadding(max, Math.max(max, textLineHeight), max, max);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YG() {
        if (this.bFb != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            setBorder(gradientDrawable);
            setBorderRadius(gradientDrawable);
            Drawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (this.mBitmap != null) {
                gradientDrawable2 = new com.baidu.swan.apps.res.ui.c(this.mBitmap, z.S((float) this.bFb.borderRadius), 0, 0);
            }
            setBackgroundDrawable(new LayerDrawable(new Drawable[]{gradientDrawable2, gradientDrawable}));
            YH();
        }
    }

    private void YH() {
        float min = Math.min(1.0f, Math.max(0.0f, (float) this.bFb.opacity));
        if (getBackground() != null) {
            setAlpha(min);
        }
    }

    private boolean i(Uri uri) {
        if (this.mBitmap != null) {
            return true;
        }
        if (this.bFa == null) {
            return false;
        }
        this.mBitmap = m.b(uri, getContext());
        if (this.mBitmap != null) {
            this.mBitmap = m.c(this.mBitmap, this.mWidth, this.mHeight);
        }
        return this.mBitmap != null;
    }

    @UiThread
    private void j(Uri uri) {
        final com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e = com.facebook.drawee.a.a.c.cDD().e(ImageRequestBuilder.R(uri).cJI(), getContext());
        e.a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.games.view.button.base.ApiButton.1
            @Override // com.facebook.imagepipeline.e.b
            public void h(@Nullable Bitmap bitmap) {
                if (com.baidu.swan.apps.ae.b.DEBUG) {
                    Log.d("ApiButton", "——> onNewResultImpl: ");
                }
                if (e.isFinished()) {
                    ApiButton.this.mBitmap = m.c(bitmap, ApiButton.this.mWidth, ApiButton.this.mHeight);
                    ApiButton.this.YG();
                    e.FH();
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.b] */
            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
                if (com.baidu.swan.apps.ae.b.DEBUG) {
                    Log.d("ApiButton", "——> onFailureImpl: " + bVar.cDo().getMessage());
                }
                ApiButton.this.YG();
                if (bVar != null) {
                    bVar.FH();
                }
            }
        }, f.cCI());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(JSEvent jSEvent) {
        if (this.bEZ != null) {
            this.bEZ.dispatchEvent(jSEvent);
        }
    }

    public boolean nn() {
        return TextUtils.equals(getType(), "text");
    }

    public boolean YI() {
        return !nn();
    }

    private int getTextLineHeight() {
        return getPaint().getFontMetricsInt().bottom - getPaint().getFontMetricsInt().top;
    }

    private int getTextTopPadding() {
        return getPaint().getFontMetricsInt().ascent - getPaint().getFontMetricsInt().top;
    }
}
