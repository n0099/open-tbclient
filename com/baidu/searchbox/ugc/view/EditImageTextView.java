package com.baidu.searchbox.ugc.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.media.ImageUtils;
import com.baidu.minivideo.plugin.capture.utils.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.draft.DraftSPWrapper;
import com.baidu.searchbox.ugc.model.HttpRequestPublishModule;
import com.baidu.searchbox.ugc.model.QuestionResponseModel;
import com.baidu.searchbox.ugc.utils.ClickSpan;
import com.baidu.searchbox.ugc.utils.DraftUtils;
import com.baidu.searchbox.ugc.utils.ImageHelper;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import com.baidu.searchbox.ugc.utils.UgcLoginUtils;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes11.dex */
public class EditImageTextView extends ImageTextView {
    private static final float IMG_ROUND_CORNER = 9.0f;
    private static final int MAX_SELECT_PHOTO = 30;
    private final String TAG;
    private TextNumbersChangedListener mListener;
    private int mMaxBitmapSize;
    private ArrayList<SpanInfo> mPreSpans;
    private String mQid;
    private ArrayList<SpanInfo> mRecycles;
    private String mTextChangedBeforeStr;
    private VideoContentDelListener mVideoContentDelListener;

    /* loaded from: classes11.dex */
    public interface TextNumbersChangedListener {
        void textChange(String str);
    }

    /* loaded from: classes11.dex */
    public interface VideoContentDelListener {
        void onVideoContentDel();
    }

    public EditImageTextView(Context context) {
        super(context);
        this.TAG = "EditImageTextView";
        this.mRecycles = new ArrayList<>();
        this.mTextChangedBeforeStr = "";
        this.mMaxBitmapSize = TbConfig.HEAD_IMG_SIZE;
        this.mPreSpans = new ArrayList<>();
        init(context);
    }

    public EditImageTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "EditImageTextView";
        this.mRecycles = new ArrayList<>();
        this.mTextChangedBeforeStr = "";
        this.mMaxBitmapSize = TbConfig.HEAD_IMG_SIZE;
        this.mPreSpans = new ArrayList<>();
        init(context);
    }

    public EditImageTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "EditImageTextView";
        this.mRecycles = new ArrayList<>();
        this.mTextChangedBeforeStr = "";
        this.mMaxBitmapSize = TbConfig.HEAD_IMG_SIZE;
        this.mPreSpans = new ArrayList<>();
        init(context);
    }

    public void setTextChangeListener(TextNumbersChangedListener textNumbersChangedListener) {
        this.mListener = textNumbersChangedListener;
    }

    public void setVideoContentDelListener(VideoContentDelListener videoContentDelListener) {
        this.mVideoContentDelListener = videoContentDelListener;
    }

    public void initQidAndBitmapSize(String str, int i) {
        this.mQid = str;
        this.mMaxBitmapSize = i;
    }

    @Override // com.baidu.searchbox.ugc.view.ImageTextView
    protected void init(Context context) {
        enableSpanClickable(false);
        enableEditable(true);
        addTextChangedListener(new TextWatcher() { // from class: com.baidu.searchbox.ugc.view.EditImageTextView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                UrlImageSpan[] urlImageSpanArr;
                Editable editableText = EditImageTextView.this.getEditableText();
                EditImageTextView.this.recycle(EditImageTextView.this.mPreSpans);
                if (editableText != null && editableText.length() != 0) {
                    EditImageTextView.this.mTextChangedBeforeStr = String.valueOf(charSequence);
                    for (UrlImageSpan urlImageSpan : (UrlImageSpan[]) editableText.getSpans(0, editableText.length(), UrlImageSpan.class)) {
                        int spanStart = editableText.getSpanStart(urlImageSpan);
                        int spanEnd = editableText.getSpanEnd(urlImageSpan);
                        SpanInfo spanInfo = EditImageTextView.this.getSpanInfo();
                        spanInfo.start = spanStart;
                        spanInfo.end = spanEnd;
                        spanInfo.span = urlImageSpan;
                        spanInfo.length = spanEnd - spanStart;
                        EditImageTextView.this.mPreSpans.add(spanInfo);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (EditImageTextView.this.mListener != null) {
                    EditImageTextView.this.mListener.textChange(EditImageTextView.this.getText().toString());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    CharacterStyle[] characterStyleArr = (CharacterStyle[]) editable.getSpans(0, editable.length(), MetricAffectingSpan.class);
                    for (int i = 0; i < characterStyleArr.length; i++) {
                        if (!(characterStyleArr[i] instanceof UrlImageSpan)) {
                            editable.removeSpan(characterStyleArr[i]);
                        }
                    }
                    int length = editable.length();
                    UrlImageSpan[] urlImageSpanArr = (UrlImageSpan[]) editable.getSpans(0, length, UrlImageSpan.class);
                    for (int i2 = 0; i2 < EditImageTextView.this.mPreSpans.size(); i2++) {
                        SpanInfo spanInfo = (SpanInfo) EditImageTextView.this.mPreSpans.get(i2);
                        for (UrlImageSpan urlImageSpan : urlImageSpanArr) {
                            if (spanInfo.span == urlImageSpan) {
                                int spanStart = editable.getSpanStart(urlImageSpan);
                                int spanEnd = editable.getSpanEnd(urlImageSpan);
                                int i3 = spanEnd - spanStart;
                                if (spanEnd < spanInfo.end && i3 < spanInfo.length) {
                                    editable.removeSpan(urlImageSpan);
                                    editable.delete(Math.min(spanStart, length), Math.min(spanEnd, length));
                                }
                            }
                        }
                    }
                    if (EditImageTextView.this.hasVideo(EditImageTextView.this.mTextChangedBeforeStr) && !EditImageTextView.this.hasVideo(editable.toString()) && EditImageTextView.this.mVideoContentDelListener != null) {
                        EditImageTextView.this.mVideoContentDelListener.onVideoContentDel();
                    }
                }
            }
        });
    }

    @Override // com.baidu.searchbox.ugc.view.ImageTextView
    public void setContentData(List<QuestionResponseModel.ReplyContentModel> list) {
        if (list != null && !list.isEmpty()) {
            super.setContentData(list);
            final Editable text = getText();
            if (text != null) {
                text.append("\n");
                text.append("\n");
                postDelayed(new Runnable() { // from class: com.baidu.searchbox.ugc.view.EditImageTextView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!TextUtils.isEmpty(text.toString())) {
                            EditImageTextView.this.setSelection(text.length());
                        }
                    }
                }, 600L);
            }
        }
    }

    public Bitmap getRoundedCornerBitmap(Bitmap bitmap, float f) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            RectF rectF = new RectF(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            canvas.drawRoundRect(rectF, f, f, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, paint);
            return createBitmap;
        } catch (Exception e) {
            return bitmap;
        }
    }

    public void insertImage(String str, Bitmap bitmap, int i) {
        UrlImageSpan urlImageSpan;
        String str2;
        int selectionStart;
        if (bitmap == null) {
            bitmap = getPlaceHolder();
        }
        Bitmap roundedCornerBitmap = getRoundedCornerBitmap(bitmap, IMG_ROUND_CORNER);
        Editable editableText = getEditableText();
        SpannableString spannableString = new SpannableString("\n");
        if (editableText.length() > 0 && (selectionStart = getSelectionStart()) > 0 && '\n' != editableText.toString().charAt(selectionStart - 1)) {
            editableText.insert(selectionStart, spannableString);
        }
        String str3 = "<img src=\"" + str + "\"/>";
        if (i == 5) {
            Bitmap drawableToBitmap = ImageUtils.drawableToBitmap(getContext().getResources().getDrawable(R.drawable.ugc_watermark_video), roundedCornerBitmap.getWidth() / 8, roundedCornerBitmap.getWidth() / 8);
            int min = Math.min(roundedCornerBitmap.getWidth(), this.mRequestWidth);
            Bitmap centerCropBitmap = ImageUtils.getCenterCropBitmap(roundedCornerBitmap, min, (min * 9) / 16);
            urlImageSpan = new UrlImageSpan(AppRuntime.getAppContext(), createWaterMarkBitmap(centerCropBitmap, this.mRequestWidth, (this.mRequestWidth * 9) / 16, drawableToBitmap, (centerCropBitmap.getWidth() - drawableToBitmap.getWidth()) / 2, (centerCropBitmap.getHeight() - drawableToBitmap.getHeight()) / 2, 5), 1, "", 0, this.mRequestWidth, this.mRequestHeight, "");
            str2 = "<video src=\"" + str + "\"></video>";
        } else if (i == 3) {
            Bitmap drawableToBitmap2 = ImageUtils.drawableToBitmap(getContext().getResources().getDrawable(R.drawable.ugc_watermark_gif_bg), this.mRequestWidth / 11, this.mRequestWidth / 22);
            Bitmap centerCropBitmap2 = ImageUtils.getCenterCropBitmap(roundedCornerBitmap, this.mRequestWidth, this.mRequestHeight);
            Bitmap drawTextAtBitmap = drawTextAtBitmap(drawableToBitmap2, "GIF", 0.0f, 0.0f);
            Bitmap createWaterMarkBitmap = createWaterMarkBitmap(centerCropBitmap2, this.mRequestWidth, this.mRequestHeight, drawTextAtBitmap, centerCropBitmap2.getWidth() - (drawTextAtBitmap.getWidth() + DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 6.0f)), centerCropBitmap2.getHeight() - (drawTextAtBitmap.getHeight() + DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 6.0f)), 3);
            urlImageSpan = new UrlImageSpan(AppRuntime.getAppContext(), createWaterMarkBitmap, 1, "", 0, createWaterMarkBitmap.getWidth(), createWaterMarkBitmap.getHeight(), "");
            str2 = str3;
        } else {
            urlImageSpan = new UrlImageSpan(AppRuntime.getAppContext(), roundedCornerBitmap, 1, "", 0, this.mRequestWidth, this.mRequestHeight, "");
            str2 = str3;
        }
        SpannableString spannableString2 = new SpannableString(str2 + "\n");
        ClickSpan clickSpan = new ClickSpan(getContext(), str, i);
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(getContext().getResources().getColor(17170443));
        spannableString2.setSpan(urlImageSpan, 0, str2.length(), 33);
        spannableString2.setSpan(clickSpan, 0, str2.length(), 33);
        spannableString2.setSpan(backgroundColorSpan, 0, str2.length(), 33);
        setMovementMethod(LinkMovementMethod.getInstance());
        int selectionStart2 = getSelectionStart();
        if (selectionStart2 < 0 || selectionStart2 >= editableText.length()) {
            editableText.append((CharSequence) spannableString2);
        } else {
            editableText.insert(selectionStart2, spannableString2);
        }
        setSelection(selectionStart2 + spannableString2.toString().length());
    }

    public void insertImageFromDraft(String str, Bitmap bitmap) {
        Bitmap placeHolder = bitmap == null ? getPlaceHolder() : bitmap;
        Editable editableText = getEditableText();
        UrlImageSpan urlImageSpan = new UrlImageSpan(AppRuntime.getAppContext(), placeHolder, 1, "", 0, this.mRequestWidth, this.mRequestHeight, "");
        String str2 = "<img src=\"" + str + "\"/>";
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(urlImageSpan, 0, str2.length(), 33);
        int selectionStart = getSelectionStart();
        if (selectionStart < 0 || selectionStart >= editableText.length()) {
            editableText.append((CharSequence) spannableString);
        } else {
            editableText.insert(selectionStart, spannableString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpanInfo getSpanInfo() {
        return this.mRecycles.size() > 0 ? this.mRecycles.remove(0) : new SpanInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recycle(ArrayList<SpanInfo> arrayList) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                this.mRecycles.add(arrayList.get(i));
            }
            arrayList.clear();
        }
    }

    public void layoutSelection() {
        getText().length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class SpanInfo {
        public int end;
        public int length;
        public UrlImageSpan span;
        public int start;

        private SpanInfo() {
        }
    }

    public static ArrayList<String> getEditTextPic(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        Matcher matcher = Pattern.compile("<img src=\"(.*?)\"/>").matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group(1));
        }
        return arrayList;
    }

    public static String replaceLocalUrl(String str, ArrayList<String> arrayList) {
        int i = 0;
        Matcher matcher = Pattern.compile("<img src=\"(.*?)\"/>").matcher(str);
        while (true) {
            int i2 = i;
            if (matcher.find()) {
                str = str.replace(matcher.group(1), arrayList.get(i2));
                i = i2 + 1;
            } else {
                return str;
            }
        }
    }

    public String replaceNewImageUrl(String str, HashMap<Integer, String> hashMap) {
        int i = 0;
        Matcher matcher = Pattern.compile("<img src=\"(.*?)\"/>").matcher(str);
        Set<Integer> keySet = hashMap.keySet();
        while (true) {
            int i2 = i;
            if (matcher.find()) {
                String group = matcher.group(1);
                if (keySet.contains(Integer.valueOf(i2))) {
                    str = str.replace(group, hashMap.get(Integer.valueOf(i2)));
                }
                i = i2 + 1;
            } else {
                return str;
            }
        }
    }

    public static String compileVideoContent(HttpRequestPublishModule.VideoUploadModel videoUploadModel) {
        if (videoUploadModel == null) {
            return "";
        }
        return "<video controls=\"controls\" source_url=\"\" poster=\"" + videoUploadModel.coverUrl + "\" cover=\"" + videoUploadModel.coverUrl + "\" size=\"" + videoUploadModel.size + "\" duration=\"" + videoUploadModel.duration + "\" media_id=\"" + videoUploadModel.mediaId + "\"  ></video>";
    }

    public boolean hasVideo(String str) {
        int i = 0;
        while (Pattern.compile("<video (.*?)></video>").matcher(str).find()) {
            i++;
        }
        return i > 0;
    }

    public boolean onlyHasVideoContent() {
        if (getText() == null) {
            return true;
        }
        int i = 0;
        while (Pattern.compile("<video (.*?)></video>").matcher(getText().toString()).find()) {
            i++;
        }
        return i > 0 && getText().toString().replaceAll("<video.+></video>", "").trim().length() == 0;
    }

    public void deleteVideo() {
        setSelection(getText().toString().indexOf("></video>") + "></video>".length());
        delKeycode();
        delKeycode();
        setSelection(getText().length());
    }

    private void delKeycode() {
        KeyEvent keyEvent = new KeyEvent(0, 67);
        KeyEvent keyEvent2 = new KeyEvent(1, 67);
        onKeyDown(67, keyEvent);
        onKeyUp(67, keyEvent2);
    }

    public void convertImageDraftContent(int i) {
        Editable editableText = getEditableText();
        Matcher matcher = Pattern.compile("<img src=\"(.*?)\"/>").matcher(editableText.toString());
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(0);
            Bitmap createBitmapThumbnail = ImageHelper.createBitmapThumbnail(group, i, i);
            if (SelectUtil.isGif(group)) {
                Bitmap drawableToBitmap = ImageUtils.drawableToBitmap(getContext().getResources().getDrawable(R.drawable.ugc_watermark_gif_bg), this.mRequestWidth / 11, this.mRequestWidth / 22);
                Bitmap centerCropBitmap = ImageUtils.getCenterCropBitmap(createBitmapThumbnail, this.mRequestWidth, this.mRequestHeight);
                Bitmap drawTextAtBitmap = drawTextAtBitmap(drawableToBitmap, "GIF", 0.0f, 0.0f);
                createBitmapThumbnail = createWaterMarkBitmap(centerCropBitmap, this.mRequestWidth, this.mRequestHeight, drawTextAtBitmap, centerCropBitmap.getWidth() - (drawTextAtBitmap.getWidth() + DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 6.0f)), centerCropBitmap.getHeight() - (drawTextAtBitmap.getHeight() + DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 6.0f)), 3);
            }
            UrlImageSpan urlImageSpan = new UrlImageSpan(AppRuntime.getAppContext(), createBitmapThumbnail, 1, "", 0, this.mRequestWidth, this.mRequestHeight, "");
            SpannableString spannableString = new SpannableString(group2);
            ClickSpan clickSpan = new ClickSpan(getContext(), group, 3);
            BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(getContext().getResources().getColor(17170443));
            spannableString.setSpan(urlImageSpan, 0, group2.length(), 33);
            spannableString.setSpan(clickSpan, 0, group2.length(), 33);
            spannableString.setSpan(backgroundColorSpan, 0, group2.length(), 33);
            setMovementMethod(LinkMovementMethod.getInstance());
            editableText.replace(matcher.start(0), matcher.end(0), spannableString);
        }
    }

    public String convertVideoDraftContent(String str) {
        String generateSPKey = DraftUtils.generateSPKey(UgcLoginUtils.getUK(), "6", str, "video_label");
        DraftSPWrapper.getInstance().getString(DraftUtils.generateSPKey(UgcLoginUtils.getUK(), "6", str, FileUtils.VIDEO_COVER_DIR), "");
        String string = DraftSPWrapper.getInstance().getString(generateSPKey, "");
        if (TextUtils.isEmpty(string) || !DraftSPWrapper.getInstance().contains(generateSPKey)) {
            return null;
        }
        Editable editableText = getEditableText();
        Matcher matcher = Pattern.compile("<video src=\"(.*?)\"></video>").matcher(editableText.toString());
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(0);
            Bitmap localVideoBitmap = com.baidu.searchbox.ugc.utils.FileUtils.getLocalVideoBitmap(group);
            if (localVideoBitmap == null) {
                return null;
            }
            Bitmap drawableToBitmap = ImageUtils.drawableToBitmap(getContext().getResources().getDrawable(R.drawable.ugc_watermark_video), localVideoBitmap.getWidth() / 8, localVideoBitmap.getWidth() / 8);
            int min = Math.min(localVideoBitmap.getWidth(), this.mRequestWidth);
            Bitmap centerCropBitmap = ImageUtils.getCenterCropBitmap(localVideoBitmap, min, (min * 9) / 16);
            UrlImageSpan urlImageSpan = new UrlImageSpan(AppRuntime.getAppContext(), createWaterMarkBitmap(centerCropBitmap, this.mRequestWidth, (this.mRequestWidth * 9) / 16, drawableToBitmap, (centerCropBitmap.getWidth() - drawableToBitmap.getWidth()) / 2, (centerCropBitmap.getHeight() - drawableToBitmap.getHeight()) / 2, 5), 1, "", 0, this.mRequestWidth, this.mRequestHeight, "");
            SpannableString spannableString = new SpannableString(group2);
            ClickSpan clickSpan = new ClickSpan(getContext(), group, 5);
            BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(getContext().getResources().getColor(17170443));
            spannableString.setSpan(urlImageSpan, 0, group2.length(), 33);
            spannableString.setSpan(clickSpan, 0, group2.length(), 33);
            spannableString.setSpan(backgroundColorSpan, 0, group2.length(), 33);
            setMovementMethod(LinkMovementMethod.getInstance());
            editableText.replace(matcher.start(0), matcher.end(0), spannableString);
        }
        return string;
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        if (i == 16908322) {
            if (getEditTextPic(getText().toString()).size() >= 30) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_question_most_select_photos_tip).showToast();
                return true;
            } else if (hasVideo(getText().toString())) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_question_video_more_tips).showToast();
                return true;
            } else {
                postDelayed(new Runnable() { // from class: com.baidu.searchbox.ugc.view.EditImageTextView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        EditImageTextView.this.convertImageDraftContent(EditImageTextView.this.mMaxBitmapSize);
                        EditImageTextView.this.convertVideoDraftContent(EditImageTextView.this.mQid);
                    }
                }, 100L);
            }
        }
        return super.onTextContextMenuItem(i);
    }
}
