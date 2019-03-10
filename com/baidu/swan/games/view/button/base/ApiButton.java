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
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.an.l;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.facebook.common.b.f;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.io.File;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class ApiButton extends AppCompatButton implements View.OnClickListener {
    private String alI;
    private EventTargetImpl bfI;
    private String bfJ;
    private a bfK;
    private Bitmap mBitmap;
    private int mHeight;
    private String mType;
    private int mWidth;

    public ApiButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context);
        this.mType = "text";
        this.bfI = eventTargetImpl;
        setSingleLine();
        setOnClickListener(this);
    }

    public ApiButton(Context context) {
        super(context);
        this.mType = "text";
    }

    public void hide() {
        if (this.bfK != null) {
            this.bfK.hidden = true;
        }
        setVisibility(8);
    }

    public void show() {
        if (this.bfK != null) {
            this.bfK.hidden = false;
        }
        setVisibility(0);
    }

    public void setApiButtonStyle(a aVar) {
        this.bfK = aVar;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setButtonText(String str) {
        if (!TextUtils.equals(str, this.alI)) {
            this.alI = str;
            if (isText() && getParent() != null) {
                setText(this.alI);
                requestLayout();
            }
        }
    }

    public void setImageUrl(String str) {
        if (!TextUtils.equals(str, this.bfJ)) {
            this.bfJ = str;
            this.mBitmap = null;
            if (PB() && getParent() != null) {
                loadImage();
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (com.baidu.swan.apps.c.DEBUG) {
            Log.d("ApiButton", "onSizeChanged mWidth=" + this.mWidth + ";mHeight" + this.mHeight);
        }
        this.mWidth = i;
        this.mHeight = i2;
        this.mBitmap = null;
        Pt();
    }

    public void Pt() {
        if (this.bfK != null && getParent() != null) {
            if (isText()) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(0);
                setBorder(gradientDrawable);
                setBorderRadius(gradientDrawable);
                setButtonBackground(gradientDrawable);
                setText(this.alI);
                Pu();
                setTextColor(M(this.bfK.color, ViewCompat.MEASURED_STATE_MASK));
                Px();
                Pw();
                Py();
                PA();
            } else {
                loadImage();
            }
            Pv();
        }
    }

    private void setButtonBackground(GradientDrawable gradientDrawable) {
        setBackgroundDrawable(new LayerDrawable(new Drawable[]{eL(M(this.bfK.backgroundColor, 0)), gradientDrawable}));
    }

    private GradientDrawable eL(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        int ad = x.ad(this.bfK.borderWidth);
        if (ad > 0) {
            gradientDrawable.setStroke(ad, a.eM(i));
        }
        if (this.bfK.borderRadius != 0.0d) {
            gradientDrawable.setCornerRadius(x.ad((float) this.bfK.borderRadius));
        }
        return gradientDrawable;
    }

    private int M(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (Pattern.compile("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6})$").matcher(str).matches()) {
                return Color.parseColor(str);
            }
            try {
                int parseColor = Color.parseColor(com.baidu.swan.apps.an.d.toColorRGBA(str));
                int i2 = parseColor >>> 24;
                return ((parseColor & 255) << 16) | (i2 << 24) | (((parseColor >> 8) & 255) << 8) | ((parseColor >> 16) & 255);
            } catch (Exception e) {
                if (com.baidu.swan.apps.c.DEBUG) {
                    e.printStackTrace();
                    return i;
                }
                return i;
            }
        }
        return i;
    }

    private void Pu() {
        setTextSize((float) this.bfK.fontSize);
    }

    private void Pv() {
        if (this.bfK.hidden) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    private void loadImage() {
        Uri uri = getUri();
        if (uri == null || k(uri)) {
            Pz();
            return;
        }
        try {
            l(uri);
        } catch (Exception e) {
            if (com.baidu.swan.apps.c.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private Uri getUri() {
        String PG;
        String str;
        if (d.gY(this.bfJ) == PathType.NETWORK) {
            return Uri.parse(this.bfJ);
        }
        if (d.gY(this.bfJ) != PathType.RELATIVE || (PG = d.PG()) == null) {
            return null;
        }
        if (this.bfJ.startsWith(".")) {
            this.bfJ = this.bfJ.substring(1);
        }
        if (this.bfJ.startsWith("/")) {
            str = PG + this.bfJ;
        } else {
            str = PG + File.separator + this.bfJ;
        }
        if (com.baidu.swan.apps.c.DEBUG) {
            Log.d("ApiButton", "——> getUri: " + str);
        }
        return Uri.parse(str);
    }

    private void Pw() {
        if (!TextUtils.isEmpty(this.bfK.textAlign)) {
            String str = this.bfK.textAlign;
            char c = 65535;
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3317767:
                    if (str.equals(CustomDialogData.POS_LEFT)) {
                        c = 0;
                        break;
                    }
                    break;
                case 108511772:
                    if (str.equals("right")) {
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

    private void Px() {
        if (!TextUtils.isEmpty(this.bfK.fontWeight)) {
            TextPaint paint = getPaint();
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            String str = this.bfK.fontWeight;
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
        if (this.bfK.borderRadius != 0.0d) {
            gradientDrawable.setCornerRadius(x.ad((float) this.bfK.borderRadius));
        }
    }

    private void setBorder(GradientDrawable gradientDrawable) {
        int ad = x.ad(this.bfK.borderWidth);
        if (ad > 0) {
            gradientDrawable.setStroke(ad, a.eM(M(this.bfK.borderColor, 0)));
        }
    }

    private void Py() {
        int ad = x.ad(this.bfK.borderWidth);
        int ad2 = x.ad(this.bfK.lineHeight);
        int textLineHeight = ad2 > 0 ? ((ad2 / 2) - (getTextLineHeight() / 2)) - getTextTopPadding() : 0;
        int max = Math.max(0, ad);
        setPadding(max, Math.max(max, textLineHeight), max, max);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pz() {
        if (this.bfK != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            setBorder(gradientDrawable);
            setBorderRadius(gradientDrawable);
            Drawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (this.mBitmap != null) {
                gradientDrawable2 = new com.baidu.swan.apps.res.ui.c(this.mBitmap, x.ad((float) this.bfK.borderRadius), 0, 0);
            }
            setBackgroundDrawable(new LayerDrawable(new Drawable[]{gradientDrawable2, gradientDrawable}));
            PA();
        }
    }

    private void PA() {
        float min = Math.min(1.0f, Math.max(0.0f, (float) this.bfK.opacity));
        if (getBackground() != null) {
            setAlpha(min);
        }
    }

    private boolean k(Uri uri) {
        if (this.mBitmap != null) {
            return true;
        }
        if (this.bfJ == null) {
            return false;
        }
        this.mBitmap = l.b(uri, getContext());
        if (this.mBitmap != null) {
            this.mBitmap = l.c(this.mBitmap, this.mWidth, this.mHeight);
        }
        return this.mBitmap != null;
    }

    @UiThread
    private void l(Uri uri) {
        final com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e = com.facebook.drawee.a.a.c.cuC().e(ImageRequestBuilder.O(uri).cAF(), getContext());
        e.a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.games.view.button.base.ApiButton.1
            @Override // com.facebook.imagepipeline.e.b
            public void f(@Nullable Bitmap bitmap) {
                if (com.baidu.swan.apps.ae.b.DEBUG) {
                    Log.d("ApiButton", "——> onNewResultImpl: ");
                }
                if (e.isFinished()) {
                    ApiButton.this.mBitmap = l.c(bitmap, ApiButton.this.mWidth, ApiButton.this.mHeight);
                    ApiButton.this.Pz();
                    e.zf();
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.b] */
            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
                if (com.baidu.swan.apps.ae.b.DEBUG) {
                    Log.d("ApiButton", "——> onFailureImpl: " + bVar.cun().getMessage());
                }
                ApiButton.this.Pz();
                if (bVar != null) {
                    bVar.zf();
                }
            }
        }, f.ctG());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(JSEvent jSEvent) {
        if (this.bfI != null) {
            this.bfI.dispatchEvent(jSEvent);
        }
    }

    public boolean isText() {
        return TextUtils.equals(getType(), "text");
    }

    public boolean PB() {
        return !isText();
    }

    private int getTextLineHeight() {
        return getPaint().getFontMetricsInt().bottom - getPaint().getFontMetricsInt().top;
    }

    private int getTextTopPadding() {
        return getPaint().getFontMetricsInt().ascent - getPaint().getFontMetricsInt().top;
    }
}
