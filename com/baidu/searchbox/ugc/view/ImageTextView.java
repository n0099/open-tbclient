package com.baidu.searchbox.ugc.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.media.ImageUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.picture.component.BaseBrowseView;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.model.QuestionResponseModel;
import com.baidu.searchbox.ugc.utils.UgcUriUtils;
import com.facebook.common.b.i;
import com.facebook.common.references.a;
import com.facebook.drawee.a.a.c;
import com.facebook.imagepipeline.common.b;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes13.dex */
public class ImageTextView extends EditText {
    private final String TAG;
    private Runnable mClickRunnable;
    private float mDownX;
    private float mDownY;
    private boolean mEditable;
    private boolean mIsMove;
    private List<QuestionResponseModel.ReplyContentModel> mList;
    private Bitmap mPlaceHolderBitmap;
    protected int mRequestHeight;
    protected int mRequestWidth;
    private boolean mSpanClick;
    private int mTouchSlop;
    float oldY;

    public ImageTextView(Context context) {
        super(context);
        this.TAG = "PATEditorView";
        this.oldY = 0.0f;
        this.mClickRunnable = new Runnable() { // from class: com.baidu.searchbox.ugc.view.ImageTextView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!ImageTextView.this.mSpanClick && !ImageTextView.this.mIsMove) {
                    ImageTextView.this.performClick();
                }
                ImageTextView.this.mSpanClick = false;
                ImageTextView.this.mIsMove = false;
            }
        };
        init(context);
    }

    public ImageTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "PATEditorView";
        this.oldY = 0.0f;
        this.mClickRunnable = new Runnable() { // from class: com.baidu.searchbox.ugc.view.ImageTextView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!ImageTextView.this.mSpanClick && !ImageTextView.this.mIsMove) {
                    ImageTextView.this.performClick();
                }
                ImageTextView.this.mSpanClick = false;
                ImageTextView.this.mIsMove = false;
            }
        };
        init(context);
    }

    public ImageTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "PATEditorView";
        this.oldY = 0.0f;
        this.mClickRunnable = new Runnable() { // from class: com.baidu.searchbox.ugc.view.ImageTextView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!ImageTextView.this.mSpanClick && !ImageTextView.this.mIsMove) {
                    ImageTextView.this.performClick();
                }
                ImageTextView.this.mSpanClick = false;
                ImageTextView.this.mIsMove = false;
            }
        };
        init(context);
    }

    protected void init(Context context) {
        enableEditable(false);
        enableSpanClickable(true);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public Bitmap getPlaceHolder() {
        return this.mPlaceHolderBitmap;
    }

    public void setPlaceHolder(Bitmap bitmap) {
        this.mPlaceHolderBitmap = bitmap;
    }

    public void enableSpanClickable(boolean z) {
        setMovementMethod(getDefaultMovementMethod());
    }

    public void enableEditable(boolean z) {
        this.mEditable = z;
    }

    public boolean isEditable() {
        return this.mEditable;
    }

    public void setContentData(List<QuestionResponseModel.ReplyContentModel> list) {
        if (list != null && !list.isEmpty()) {
            if (this.mList == null) {
                this.mList = new ArrayList(list);
            } else if (!this.mList.equals(list)) {
                this.mList.clear();
                this.mList.addAll(list);
            } else {
                return;
            }
            setText(createSpannableString());
            loadImageSpan();
        }
    }

    protected void loadImageSpan() {
        UrlImageSpan[] urlImageSpanArr;
        Editable text = getText();
        for (UrlImageSpan urlImageSpan : (UrlImageSpan[]) text.getSpans(0, text.length(), UrlImageSpan.class)) {
            loadEditTextImage(urlImageSpan.getUrl(), urlImageSpan.getType(), urlImageSpan.getdetailType());
        }
    }

    protected Spanned createSpannableString() {
        boolean z;
        if (this.mList == null || this.mList.isEmpty()) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mList.size()) {
                return spannableStringBuilder;
            }
            QuestionResponseModel.ReplyContentModel replyContentModel = this.mList.get(i2);
            if (!TextUtils.isEmpty(replyContentModel.type)) {
                if (QuestionResponseModel.TEXT.equals(replyContentModel.type)) {
                    spannableStringBuilder.append((CharSequence) replyContentModel.data.value);
                } else if ("image".equals(replyContentModel.type)) {
                    boolean z2 = false;
                    if (i2 == 0) {
                        z2 = false;
                        z = true;
                    } else if (!this.mList.get(i2 - 1).type.equals("image")) {
                        z = false;
                    } else {
                        z2 = false;
                        z = true;
                    }
                    boolean z3 = i2 == this.mList.size() + (-1) ? false : z;
                    String str = "<img src=\"" + replyContentModel.data.origin.src + "\"/>";
                    SpannableString spannableString = new SpannableString(str);
                    spannableString.setSpan(new UrlImageSpan(AppRuntime.getAppContext(), getPlaceHolder(), 1, replyContentModel.data.origin.src, 2, this.mRequestWidth, this.mRequestHeight, z2, z3, replyContentModel.data.origin.pic_type), 0, str.length(), 33);
                    String spannableStringBuilder2 = spannableStringBuilder.toString();
                    if (!TextUtils.isEmpty(spannableStringBuilder2) && '\n' != spannableStringBuilder2.charAt(spannableStringBuilder2.length() - 1)) {
                        spannableStringBuilder.append((CharSequence) "\n");
                    }
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) "\n");
                } else {
                    boolean z4 = false;
                    boolean z5 = false;
                    if (i2 == 0) {
                        z4 = false;
                        z5 = true;
                    } else if (this.mList.get(i2 - 1).type.equals("video")) {
                        z4 = false;
                        z5 = true;
                    }
                    String compileEditVideoLabel = compileEditVideoLabel(replyContentModel.data);
                    SpannableString spannableString2 = new SpannableString(compileEditVideoLabel);
                    spannableString2.setSpan(new UrlImageSpan(AppRuntime.getAppContext(), getPlaceHolder(), 1, replyContentModel.data.cover, 5, this.mRequestWidth, this.mRequestHeight, z4, z5, ""), 0, compileEditVideoLabel.length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.oldY = motionEvent.getY();
                requestFocus();
                break;
            case 2:
                if (Math.abs(this.oldY - motionEvent.getY()) > 20.0f) {
                    clearFocus();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setRequestImageSize(int i, int i2) {
        this.mRequestWidth = i;
        this.mRequestHeight = i2;
    }

    public void loadEditTextImage(final String str, final int i, final String str2) {
        Uri uri = UgcUriUtils.getUri(str);
        c.dlB().e(ImageRequestBuilder.Y(uri).a(b.doo().vo(true).vn(true).dow()).dsD(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.searchbox.ugc.view.ImageTextView.1
            @Override // com.facebook.imagepipeline.e.b
            protected void onNewResultImpl(Bitmap bitmap) {
                UrlImageSpan[] urlImageSpanArr;
                UrlImageSpan urlImageSpan;
                if (bitmap == null || bitmap.isRecycled()) {
                    bitmap = ImageTextView.this.mPlaceHolderBitmap;
                }
                Editable text = ImageTextView.this.getText();
                Bitmap bitmap2 = bitmap;
                for (UrlImageSpan urlImageSpan2 : (UrlImageSpan[]) text.getSpans(0, text.length(), UrlImageSpan.class)) {
                    if (str.equals(urlImageSpan2.getUrl())) {
                        if (i == 2) {
                            if (!TextUtils.isEmpty(str2) && BaseBrowseView.IMG_TYPE_GIF.equals(str2)) {
                                Bitmap drawableToBitmap = ImageUtils.drawableToBitmap(ImageTextView.this.getContext().getResources().getDrawable(R.drawable.ugc_watermark_gif_bg), ImageTextView.this.mRequestWidth / 11, ImageTextView.this.mRequestWidth / 22);
                                Bitmap centerCropBitmap = ImageUtils.getCenterCropBitmap(bitmap2, ImageTextView.this.mRequestWidth, ImageTextView.this.mRequestHeight);
                                Bitmap drawTextAtBitmap = ImageTextView.drawTextAtBitmap(drawableToBitmap, "GIF", 0.0f, 0.0f);
                                bitmap2 = ImageTextView.this.createWaterMarkBitmap(centerCropBitmap, ImageTextView.this.mRequestWidth, ImageTextView.this.mRequestHeight, drawTextAtBitmap, centerCropBitmap.getWidth() - (drawTextAtBitmap.getWidth() + DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 6.0f)), centerCropBitmap.getHeight() - (drawTextAtBitmap.getHeight() + DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 6.0f)), 3);
                                urlImageSpan = new UrlImageSpan(AppRuntime.getAppContext(), bitmap2, 1, str, 2, bitmap2.getWidth(), bitmap2.getHeight(), urlImageSpan2.useMarginTop(), urlImageSpan2.userMarginBottom(), "");
                            } else {
                                urlImageSpan = new UrlImageSpan(AppRuntime.getAppContext(), bitmap2, 1, str, 2, ImageTextView.this.mRequestWidth, ImageTextView.this.mRequestHeight, urlImageSpan2.useMarginTop(), urlImageSpan2.userMarginBottom(), "");
                            }
                        } else {
                            Bitmap drawableToBitmap2 = ImageUtils.drawableToBitmap(ImageTextView.this.getContext().getResources().getDrawable(R.drawable.ugc_watermark_video), bitmap2.getWidth() / 8, bitmap2.getWidth() / 8);
                            int min = Math.min(bitmap2.getWidth(), ImageTextView.this.mRequestWidth);
                            Bitmap centerCropBitmap2 = ImageUtils.getCenterCropBitmap(bitmap2, min, (min * 9) / 16);
                            bitmap2 = ImageTextView.this.createWaterMarkBitmap(centerCropBitmap2, ImageTextView.this.mRequestWidth, (ImageTextView.this.mRequestWidth * 9) / 16, drawableToBitmap2, (centerCropBitmap2.getWidth() - drawableToBitmap2.getWidth()) / 2, (centerCropBitmap2.getHeight() - drawableToBitmap2.getHeight()) / 2, 5);
                            urlImageSpan = new UrlImageSpan(AppRuntime.getAppContext(), bitmap2, 1, str, 2, ImageTextView.this.mRequestWidth, ImageTextView.this.mRequestHeight, urlImageSpan2.useMarginTop(), urlImageSpan2.userMarginBottom(), "");
                        }
                        int spanStart = text.getSpanStart(urlImageSpan2);
                        int spanEnd = text.getSpanEnd(urlImageSpan2);
                        int spanFlags = text.getSpanFlags(urlImageSpan2);
                        urlImageSpan.setLoadImageResult(true);
                        text.setSpan(urlImageSpan, spanStart, spanEnd, spanFlags);
                        text.removeSpan(urlImageSpan2);
                    }
                }
                ImageTextView.this.setText(new SpannableString(text));
            }

            @Override // com.facebook.datasource.a
            protected void onFailureImpl(com.facebook.datasource.b<a<com.facebook.imagepipeline.g.c>> bVar) {
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void onCancellation(com.facebook.datasource.b<a<com.facebook.imagepipeline.g.c>> bVar) {
                super.onCancellation(bVar);
            }
        }, i.dkG());
    }

    public Bitmap createWaterMarkBitmap(Bitmap bitmap, int i, int i2, Bitmap bitmap2, int i3, int i4, int i5) {
        Bitmap createBitmap;
        if (bitmap == null || bitmap2 == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i <= 0 || i >= width) {
            i = width;
        }
        if (i2 <= 0 || i2 >= height) {
            i2 = height;
        }
        if (i5 == 5) {
            int i6 = (i * 9) / 16;
            i3 = (i - bitmap2.getWidth()) / 2;
            i4 = (i6 - bitmap2.getHeight()) / 2;
            createBitmap = Bitmap.createBitmap(i, i6, Bitmap.Config.ARGB_8888);
        } else {
            createBitmap = Bitmap.createBitmap(this.mRequestWidth, i2, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.drawBitmap(bitmap2, i3, i4, paint);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public static Bitmap drawTextAtBitmap(Bitmap bitmap, String str, float f, float f2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        TextPaint textPaint = new TextPaint();
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, textPaint);
        textPaint.setColor(-1);
        textPaint.setDither(true);
        textPaint.setFilterBitmap(true);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), width / 10));
        Rect rect = new Rect();
        textPaint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(str, (width / 2) - (rect.width() / 2), (height / 2) + (rect.height() / 2), textPaint);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable() || isLongClickable()) {
            switch (motionEvent.getAction()) {
                case 0:
                    removeCallbacks(this.mClickRunnable);
                    this.mSpanClick = false;
                    this.mIsMove = false;
                    this.mDownX = motionEvent.getX();
                    this.mDownY = motionEvent.getY();
                    break;
                case 1:
                    post(this.mClickRunnable);
                    break;
                case 2:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if ((Math.abs(x - this.mDownX) > this.mTouchSlop || Math.abs(y - this.mDownY) > this.mTouchSlop) && !this.mIsMove) {
                        this.mIsMove = true;
                        break;
                    }
                    break;
                case 3:
                    this.mSpanClick = false;
                    this.mIsMove = false;
                    break;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public static String compileEditVideoLabel(QuestionResponseModel.ReplyData replyData) {
        if (replyData == null) {
            return "";
        }
        return "<video controls=\"controls\" source_url=\"\" poster=\"" + replyData.cover + "\" cover=\"" + replyData.cover + "\" size=\"" + replyData.size + "\" duration=\"" + replyData.duration + "\" media_id=\"" + replyData.mediaId + "\"  ></video>";
    }

    public static int measureBitmapWidth(int i, Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        int width = bitmap.getWidth();
        int dp2px = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 330.0f);
        return width <= dp2px ? width : dp2px;
    }

    public static int measureBitmapHeight(int i, Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        int measureBitmapWidth = measureBitmapWidth(i, bitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i == 5) {
            return (measureBitmapWidth * 9) / 16;
        }
        return (measureBitmapWidth * height) / width;
    }
}
