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
    private String alO;
    private EventTargetImpl bfN;
    private String bfO;
    private a bfP;
    private Bitmap mBitmap;
    private int mHeight;
    private String mType;
    private int mWidth;

    public ApiButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context);
        this.mType = "text";
        this.bfN = eventTargetImpl;
        setSingleLine();
        setOnClickListener(this);
    }

    public ApiButton(Context context) {
        super(context);
        this.mType = "text";
    }

    public void hide() {
        if (this.bfP != null) {
            this.bfP.hidden = true;
        }
        setVisibility(8);
    }

    public void show() {
        if (this.bfP != null) {
            this.bfP.hidden = false;
        }
        setVisibility(0);
    }

    public void setApiButtonStyle(a aVar) {
        this.bfP = aVar;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setButtonText(String str) {
        if (!TextUtils.equals(str, this.alO)) {
            this.alO = str;
            if (isText() && getParent() != null) {
                setText(this.alO);
                requestLayout();
            }
        }
    }

    public void setImageUrl(String str) {
        if (!TextUtils.equals(str, this.bfO)) {
            this.bfO = str;
            this.mBitmap = null;
            if (Pz() && getParent() != null) {
                loadImage();
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
        Pr();
    }

    public void Pr() {
        if (this.bfP != null && getParent() != null) {
            if (isText()) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(0);
                setBorder(gradientDrawable);
                setBorderRadius(gradientDrawable);
                setButtonBackground(gradientDrawable);
                setText(this.alO);
                Ps();
                setTextColor(M(this.bfP.color, ViewCompat.MEASURED_STATE_MASK));
                Pv();
                Pu();
                Pw();
                Py();
            } else {
                loadImage();
            }
            Pt();
        }
    }

    private void setButtonBackground(GradientDrawable gradientDrawable) {
        setBackgroundDrawable(new LayerDrawable(new Drawable[]{eK(M(this.bfP.backgroundColor, 0)), gradientDrawable}));
    }

    private GradientDrawable eK(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        int ad = x.ad(this.bfP.borderWidth);
        if (ad > 0) {
            gradientDrawable.setStroke(ad, a.eL(i));
        }
        if (this.bfP.borderRadius != 0.0d) {
            gradientDrawable.setCornerRadius(x.ad((float) this.bfP.borderRadius));
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
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                    return i;
                }
                return i;
            }
        }
        return i;
    }

    private void Ps() {
        setTextSize((float) this.bfP.fontSize);
    }

    private void Pt() {
        if (this.bfP.hidden) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    private void loadImage() {
        Uri uri = getUri();
        if (uri == null || k(uri)) {
            Px();
            return;
        }
        try {
            l(uri);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private Uri getUri() {
        String PE;
        String str;
        if (d.gZ(this.bfO) == PathType.NETWORK) {
            return Uri.parse(this.bfO);
        }
        if (d.gZ(this.bfO) != PathType.RELATIVE || (PE = d.PE()) == null) {
            return null;
        }
        if (this.bfO.startsWith(".")) {
            this.bfO = this.bfO.substring(1);
        }
        if (this.bfO.startsWith("/")) {
            str = PE + this.bfO;
        } else {
            str = PE + File.separator + this.bfO;
        }
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("ApiButton", "——> getUri: " + str);
        }
        return Uri.parse(str);
    }

    private void Pu() {
        if (!TextUtils.isEmpty(this.bfP.textAlign)) {
            String str = this.bfP.textAlign;
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

    private void Pv() {
        if (!TextUtils.isEmpty(this.bfP.fontWeight)) {
            TextPaint paint = getPaint();
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            String str = this.bfP.fontWeight;
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
        if (this.bfP.borderRadius != 0.0d) {
            gradientDrawable.setCornerRadius(x.ad((float) this.bfP.borderRadius));
        }
    }

    private void setBorder(GradientDrawable gradientDrawable) {
        int ad = x.ad(this.bfP.borderWidth);
        if (ad > 0) {
            gradientDrawable.setStroke(ad, a.eL(M(this.bfP.borderColor, 0)));
        }
    }

    private void Pw() {
        int ad = x.ad(this.bfP.borderWidth);
        int ad2 = x.ad(this.bfP.lineHeight);
        int textLineHeight = ad2 > 0 ? ((ad2 / 2) - (getTextLineHeight() / 2)) - getTextTopPadding() : 0;
        int max = Math.max(0, ad);
        setPadding(max, Math.max(max, textLineHeight), max, max);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Px() {
        if (this.bfP != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            setBorder(gradientDrawable);
            setBorderRadius(gradientDrawable);
            Drawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (this.mBitmap != null) {
                gradientDrawable2 = new com.baidu.swan.apps.res.ui.c(this.mBitmap, x.ad((float) this.bfP.borderRadius), 0, 0);
            }
            setBackgroundDrawable(new LayerDrawable(new Drawable[]{gradientDrawable2, gradientDrawable}));
            Py();
        }
    }

    private void Py() {
        float min = Math.min(1.0f, Math.max(0.0f, (float) this.bfP.opacity));
        if (getBackground() != null) {
            setAlpha(min);
        }
    }

    private boolean k(Uri uri) {
        if (this.mBitmap != null) {
            return true;
        }
        if (this.bfO == null) {
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
        final com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e = com.facebook.drawee.a.a.c.cuy().e(ImageRequestBuilder.O(uri).cAB(), getContext());
        e.a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.games.view.button.base.ApiButton.1
            @Override // com.facebook.imagepipeline.e.b
            public void f(@Nullable Bitmap bitmap) {
                if (com.baidu.swan.apps.ae.b.DEBUG) {
                    Log.d("ApiButton", "——> onNewResultImpl: ");
                }
                if (e.isFinished()) {
                    ApiButton.this.mBitmap = l.c(bitmap, ApiButton.this.mWidth, ApiButton.this.mHeight);
                    ApiButton.this.Px();
                    e.ze();
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.b] */
            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
                if (com.baidu.swan.apps.ae.b.DEBUG) {
                    Log.d("ApiButton", "——> onFailureImpl: " + bVar.cuj().getMessage());
                }
                ApiButton.this.Px();
                if (bVar != null) {
                    bVar.ze();
                }
            }
        }, f.ctC());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(JSEvent jSEvent) {
        if (this.bfN != null) {
            this.bfN.dispatchEvent(jSEvent);
        }
    }

    public boolean isText() {
        return TextUtils.equals(getType(), "text");
    }

    public boolean Pz() {
        return !isText();
    }

    private int getTextLineHeight() {
        return getPaint().getFontMetricsInt().bottom - getPaint().getFontMetricsInt().top;
    }

    private int getTextTopPadding() {
        return getPaint().getFontMetricsInt().ascent - getPaint().getFontMetricsInt().top;
    }
}
