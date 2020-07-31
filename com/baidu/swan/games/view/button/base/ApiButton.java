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
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.h;
import com.baidu.swan.apps.aq.s;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.PathType;
import com.facebook.common.b.i;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.io.File;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class ApiButton extends AppCompatButton implements View.OnClickListener {
    private EventTargetImpl dnV;
    private a dnW;
    private Bitmap mBitmap;
    private int mHeight;
    private String mImage;
    private String mText;
    private String mType;
    private int mWidth;

    public ApiButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context);
        this.mType = "text";
        this.dnV = eventTargetImpl;
        setSingleLine();
        setOnClickListener(this);
    }

    public ApiButton(Context context) {
        super(context);
        this.mType = "text";
    }

    public void hide() {
        if (this.dnW != null) {
            this.dnW.hidden = true;
        }
        setVisibility(8);
    }

    public void show() {
        if (this.dnW != null) {
            this.dnW.hidden = false;
        }
        setVisibility(0);
    }

    public void setApiButtonStyle(a aVar) {
        this.dnW = aVar;
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
            if (uf() && getParent() != null) {
                setText(this.mText);
                requestLayout();
            }
        }
    }

    public void setImageUrl(String str) {
        if (!TextUtils.equals(str, this.mImage)) {
            this.mImage = str;
            this.mBitmap = null;
            if (PE() && getParent() != null) {
                KG();
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
        aHH();
    }

    public void aHH() {
        if (this.dnW != null && getParent() != null) {
            if (uf()) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(0);
                setBorder(gradientDrawable);
                setBorderRadius(gradientDrawable);
                setButtonBackground(gradientDrawable);
                setText(this.mText);
                aHI();
                setTextColor(Y(this.dnW.color, ViewCompat.MEASURED_STATE_MASK));
                aHL();
                aHK();
                aHM();
                aHO();
            } else {
                KG();
            }
            aHJ();
        }
    }

    private void setButtonBackground(GradientDrawable gradientDrawable) {
        setBackgroundDrawable(new LayerDrawable(new Drawable[]{jb(Y(this.dnW.backgroundColor, 0)), gradientDrawable}));
    }

    private GradientDrawable jb(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        int D = ai.D(this.dnW.borderWidth);
        if (D > 0) {
            gradientDrawable.setStroke(D, a.jc(i));
        }
        if (this.dnW.borderRadius != 0.0d) {
            gradientDrawable.setCornerRadius(ai.D((float) this.dnW.borderRadius));
        }
        return gradientDrawable;
    }

    private int Y(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (Pattern.compile("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6})$").matcher(str).matches()) {
                return Color.parseColor(str);
            }
            try {
                int parseColor = Color.parseColor(h.toColorRGBA(str));
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

    private void aHI() {
        setTextSize((float) this.dnW.fontSize);
    }

    private void aHJ() {
        if (this.dnW.hidden) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    private void KG() {
        Uri uri = getUri();
        if (uri == null || m(uri)) {
            aHN();
            return;
        }
        try {
            n(uri);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private Uri getUri() {
        String aHT;
        String str;
        if (c.pJ(this.mImage) == PathType.NETWORK) {
            return Uri.parse(this.mImage);
        }
        if (c.pJ(this.mImage) != PathType.RELATIVE || (aHT = c.aHT()) == null) {
            return null;
        }
        if (this.mImage.startsWith(".")) {
            this.mImage = this.mImage.substring(1);
        }
        if (this.mImage.startsWith("/")) {
            str = aHT + this.mImage;
        } else {
            str = aHT + File.separator + this.mImage;
        }
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("ApiButton", "——> getUri: " + str);
        }
        return Uri.parse(str);
    }

    private void aHK() {
        if (!TextUtils.isEmpty(this.dnW.textAlign)) {
            String str = this.dnW.textAlign;
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
                    if (str.equals(HorizontalTranslateLayout.DIRECTION_RIGHT)) {
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

    private void aHL() {
        if (!TextUtils.isEmpty(this.dnW.fontWeight)) {
            TextPaint paint = getPaint();
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            String str = this.dnW.fontWeight;
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
        if (this.dnW.borderRadius != 0.0d) {
            gradientDrawable.setCornerRadius(ai.D((float) this.dnW.borderRadius));
        }
    }

    private void setBorder(GradientDrawable gradientDrawable) {
        int D = ai.D(this.dnW.borderWidth);
        if (D > 0) {
            gradientDrawable.setStroke(D, a.jc(Y(this.dnW.borderColor, 0)));
        }
    }

    private void aHM() {
        int D = ai.D(this.dnW.borderWidth);
        int D2 = ai.D(this.dnW.lineHeight);
        int textLineHeight = D2 > 0 ? ((D2 / 2) - (getTextLineHeight() / 2)) - getTextTopPadding() : 0;
        int max = Math.max(0, D);
        setPadding(max, Math.max(max, textLineHeight), max, max);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHN() {
        if (this.dnW != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            setBorder(gradientDrawable);
            setBorderRadius(gradientDrawable);
            Drawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (this.mBitmap != null) {
                gradientDrawable2 = new com.baidu.swan.apps.res.ui.c(this.mBitmap, ai.D((float) this.dnW.borderRadius), 0, 0);
            }
            setBackgroundDrawable(new LayerDrawable(new Drawable[]{gradientDrawable2, gradientDrawable}));
            aHO();
        }
    }

    private void aHO() {
        float min = Math.min(1.0f, Math.max(0.0f, (float) this.dnW.opacity));
        if (getBackground() != null) {
            setAlpha(min);
        }
    }

    private boolean m(Uri uri) {
        if (this.mBitmap != null) {
            return true;
        }
        if (this.mImage == null) {
            return false;
        }
        this.mBitmap = s.b(uri, getContext());
        if (this.mBitmap != null) {
            this.mBitmap = s.c(this.mBitmap, this.mWidth, this.mHeight);
        }
        return this.mBitmap != null;
    }

    @UiThread
    private void n(Uri uri) {
        final com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> e = com.facebook.drawee.a.a.c.dDo().e(ImageRequestBuilder.ab(uri).dKr(), getContext());
        e.a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.games.view.button.base.ApiButton.1
            @Override // com.facebook.imagepipeline.e.b
            public void h(@Nullable Bitmap bitmap) {
                if (e.DEBUG) {
                    Log.d("ApiButton", "——> onNewResultImpl: ");
                }
                if (e.isFinished()) {
                    ApiButton.this.mBitmap = s.c(bitmap, ApiButton.this.mWidth, ApiButton.this.mHeight);
                    ApiButton.this.aHN();
                    e.abo();
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.b] */
            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> bVar) {
                if (e.DEBUG) {
                    Log.d("ApiButton", "——> onFailureImpl: " + bVar.dCX().getMessage());
                }
                ApiButton.this.aHN();
                if (bVar != null) {
                    bVar.abo();
                }
            }
        }, i.dCu());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(JSEvent jSEvent) {
        if (this.dnV != null) {
            this.dnV.dispatchEvent(jSEvent);
        }
    }

    public boolean uf() {
        return TextUtils.equals(getType(), "text");
    }

    public boolean PE() {
        return !uf();
    }

    private int getTextLineHeight() {
        return getPaint().getFontMetricsInt().bottom - getPaint().getFontMetricsInt().top;
    }

    private int getTextTopPadding() {
        return getPaint().getFontMetricsInt().ascent - getPaint().getFontMetricsInt().top;
    }
}
