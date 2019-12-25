package com.baidu.searchbox.ugc.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Environment;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.android.ext.widget.dialog.BdProgressDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.minivideo.plugin.capture.utils.FileUtils;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.datachannel.Sender;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.publisher.event.StartPublishEvent;
import com.baidu.searchbox.publisher.event.UpdateVideoCoverEvent;
import com.baidu.searchbox.publisher.video.interfaces.IPublisherSboxVideoInterface;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.draft.DraftSPWrapper;
import com.baidu.searchbox.ugc.model.HttpRequestPublishModule;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.model.PublishRequestModel;
import com.baidu.searchbox.ugc.model.QuestionResponseModel;
import com.baidu.searchbox.ugc.request.PublishRequestManager;
import com.baidu.searchbox.ugc.upload.UploadFileTask;
import com.baidu.searchbox.ugc.upload.UploadImageTask;
import com.baidu.searchbox.ugc.upload.UploadManager;
import com.baidu.searchbox.ugc.utils.DialogUtils;
import com.baidu.searchbox.ugc.utils.DraftUtils;
import com.baidu.searchbox.ugc.utils.ImageHelper;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import com.baidu.searchbox.ugc.utils.UgcDialogUtils;
import com.baidu.searchbox.ugc.utils.UgcLoginUtils;
import com.baidu.searchbox.ugc.utils.UgcSharePrefsUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.utils.UgcUiUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import com.baidu.searchbox.ugc.view.EditImageTextView;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import com.baidu.searchbox.widget.ImmersionHelper;
import com.baidu.tbadk.TbConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import rx.functions.b;
/* loaded from: classes11.dex */
public class QuestionsPublishActivity extends BaseActivity implements View.OnClickListener, EditImageTextView.TextNumbersChangedListener {
    private static final int COVER = 1;
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final int LOCAL_ALBUM_CODE = 32776;
    public static final int MAXTEXTSIZES = 8000;
    private static final int MAX_PROGRESS = 100;
    private static final int MAX_SELECT_PHOTO = 30;
    private static final int MAX_SELECT_VIDEO = 1;
    private static final int PHOTO = 0;
    public static final String QUESTION_DRAFT_TIMEOUT_INFO_SP_KEY = "question_draft_timeout_info";
    public static final long QUESTION_DRAFT_TIMEOUT_THRESHOLD = 432000000;
    public static final String TAG = "QuestionsPbActivity";
    private UgcSchemeModel answerInfo;
    private JSONObject extInfo;
    private HashMap<Integer, String> hashMap;
    private BdProgressDialog mBdProgressDialog;
    private View mBottomLineView;
    private int mBottomNavigationKeyHeight;
    private RelativeLayout mBottomRelativeLayout;
    private TextView mCancel;
    private ImageView mCloseUploadImg;
    private EditImageTextView mEditImageTextView;
    private String mEditTextContent;
    private RelativeLayout mHeaderRelativeLayout;
    private int mHeight;
    private int mInputMethodHeight;
    private boolean mIsFirstGlobalLayout;
    private boolean mIsSuccess;
    private ImageView mKeycodeImg;
    private String mMediaId;
    private ImageView mPhotoEnterImg;
    private TextView mPublishTv;
    private RelativeLayout mRelativeLayout;
    private String mSourceKey;
    private TextView mTextNumber;
    private TextView mTitle;
    private View mTitleLineView;
    private View mUgcLineView;
    private TextView mUgcTitle;
    private View mUploadVideoProgress;
    private String mVideoCover;
    private ImageView mVideoEnterImg;
    private String mVideoLabel;
    private String mVideoPath;
    private TextView mVideoProgressTv;
    private TextView mVideoTip;
    private int mWidth;
    private String placeHolder;
    private String placeTitle;
    private String postUrl;
    private String qid;
    private String rid;
    private String sourceFrom;
    private String title;
    private String ugcCallback;
    private ArrayList<String> uploadPic;
    private boolean mIsVideoUploadding = false;
    private boolean mIsImageUploadding = false;
    private boolean isEdit = false;
    private boolean mEnableClick = false;
    private int mMaxBitmapSize = TbConfig.HEAD_IMG_SIZE;
    private int mIndex = 0;
    private List<String> imageUrlList = new ArrayList();
    private List<Integer> indexList = new ArrayList();
    int mLastVisibleHeight = -1;
    private EditImageTextView.VideoContentDelListener videoContentDelListener = new EditImageTextView.VideoContentDelListener() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.1
        @Override // com.baidu.searchbox.ugc.view.EditImageTextView.VideoContentDelListener
        public void onVideoContentDel() {
            if (QuestionsPublishActivity.this.mUploadVideoProgress != null) {
                if (QuestionsPublishActivity.this.mIsVideoUploadding) {
                    UploadManager.getInstance().stopAll();
                    QuestionsPublishActivity.this.mIsVideoUploadding = false;
                }
                UiBaseUtils.setVisibility(QuestionsPublishActivity.this.mUploadVideoProgress, 8);
            }
        }
    };

    static /* synthetic */ int access$2808(QuestionsPublishActivity questionsPublishActivity) {
        int i = questionsPublishActivity.mIndex;
        questionsPublishActivity.mIndex = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        timeoutCleanDraft();
        setContentView(R.layout.ugc_question_reply_layout);
        initData();
        initView();
        updateUiForNightMod();
        registerEvent();
        if (this.mEditImageTextView != null) {
            this.mEditImageTextView.initQidAndBitmapSize(this.qid, this.mMaxBitmapSize);
        }
        if (!this.isEdit) {
            handleDraftData(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        showInput(this.mEditImageTextView);
        initGuideTips();
        if (this.mEditImageTextView.getText() != null && !TextUtils.isEmpty(this.mEditImageTextView.getText().toString())) {
            setAbleClick();
            setEdittextSelectionInEnd(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEdittextSelectionInEnd(long j) {
        if (this.mEditImageTextView != null) {
            this.mEditImageTextView.postDelayed(new Runnable() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    if (QuestionsPublishActivity.this.mEditImageTextView != null) {
                        QuestionsPublishActivity.this.mEditImageTextView.setSelection(QuestionsPublishActivity.this.mEditImageTextView.getText().toString().length());
                    }
                }
            }, j);
        }
    }

    private void initData() {
        if (getIntent() != null) {
            this.answerInfo = (UgcSchemeModel) getIntent().getSerializableExtra("data");
            if (this.answerInfo != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.answerInfo.questionReply);
                    this.qid = jSONObject.optString("qid");
                    this.rid = jSONObject.optString("rid");
                    this.title = jSONObject.optString("title");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.postUrl = this.answerInfo.url;
                this.sourceFrom = this.answerInfo.sourceFrom;
                this.ugcCallback = this.answerInfo.ugcCallback;
                this.placeHolder = this.answerInfo.placeholder;
                this.placeTitle = this.answerInfo.placeTitle;
                if (!TextUtils.isEmpty(this.answerInfo.ext)) {
                    try {
                        this.extInfo = new JSONObject(this.answerInfo.ext);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        this.mMaxBitmapSize = getResources().getDisplayMetrics().widthPixels / 2;
        UgcUBCUtils.answerStatistics(UgcUBCUtils.UGC_TYPE_EDIT_VIEW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDraftData(boolean z) {
        String generateSPKey = DraftUtils.generateSPKey(UgcLoginUtils.getUK(), "6", this.qid);
        if (z) {
            cleanDraft(generateSPKey);
            return;
        }
        String string = DraftSPWrapper.getInstance().getString(generateSPKey, "");
        if (!TextUtils.isEmpty(string) && this.mEditImageTextView != null) {
            UiBaseUtils.setTextString(this.mEditImageTextView, string);
            this.mEditImageTextView.convertImageDraftContent(this.mMaxBitmapSize);
            this.mVideoLabel = this.mEditImageTextView.convertVideoDraftContent(this.qid);
        }
    }

    private void timeoutCleanDraft() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.3
            @Override // java.lang.Runnable
            public void run() {
                String string = DraftSPWrapper.getInstance().getString(QuestionsPublishActivity.QUESTION_DRAFT_TIMEOUT_INFO_SP_KEY, "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            String optString = jSONObject.optString(next);
                            if (!TextUtils.isEmpty(optString) && System.currentTimeMillis() - Long.valueOf(optString).longValue() > QuestionsPublishActivity.QUESTION_DRAFT_TIMEOUT_THRESHOLD) {
                                QuestionsPublishActivity.this.cleanDraft(next);
                            }
                        }
                    } catch (JSONException e) {
                        if (QuestionsPublishActivity.DEBUG) {
                            Log.d(QuestionsPublishActivity.TAG, "QuestionsPbActivity e.toString() " + e.toString());
                        }
                    } catch (Exception e2) {
                        if (QuestionsPublishActivity.DEBUG) {
                            Log.d(QuestionsPublishActivity.TAG, "QuestionsPbActivity e.toString() " + e2.toString());
                        }
                    }
                }
            }
        }, "question_timeout_clean_draft", 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanDraft(String str) {
        if (DraftSPWrapper.getInstance().contains(str)) {
            DraftSPWrapper.getInstance().remove(str);
            clearVideoDrafData();
            cleanDraftTimeInfo(str);
        }
    }

    private void clearVideoDrafData() {
        String generateSPKey = DraftUtils.generateSPKey(UgcLoginUtils.getUK(), "6", this.qid, "video_label");
        String generateSPKey2 = DraftUtils.generateSPKey(UgcLoginUtils.getUK(), "6", this.qid, FileUtils.VIDEO_COVER_DIR);
        if (DraftSPWrapper.getInstance().contains(generateSPKey)) {
            DraftSPWrapper.getInstance().remove(generateSPKey);
        }
        if (DraftSPWrapper.getInstance().contains(generateSPKey2)) {
            DraftSPWrapper.getInstance().remove(generateSPKey2);
        }
    }

    public void saveVideoDraftInfo(String str, String str2, String str3) {
        String generateSPKey = DraftUtils.generateSPKey(UgcLoginUtils.getUK(), "6", str, "video_label");
        String generateSPKey2 = DraftUtils.generateSPKey(UgcLoginUtils.getUK(), "6", str, FileUtils.VIDEO_COVER_DIR);
        DraftSPWrapper.getInstance().putString(generateSPKey, str2);
        DraftSPWrapper.getInstance().putString(generateSPKey2, str3);
    }

    private void initView() {
        this.mRelativeLayout = (RelativeLayout) findViewById(ResourceUtils.getResIdByName("ugc_question_reply_rl"));
        this.mHeaderRelativeLayout = (RelativeLayout) findViewById(ResourceUtils.getResIdByName("ugc_answer_publish_header"));
        this.mBottomRelativeLayout = (RelativeLayout) findViewById(ResourceUtils.getResIdByName("ugc_publish_bottom_rl"));
        this.mUgcLineView = findViewById(ResourceUtils.getResIdByName("ugc_line"));
        this.mTitleLineView = findViewById(ResourceUtils.getResIdByName("ugc_title_line"));
        this.mBottomLineView = findViewById(ResourceUtils.getResIdByName("ugc_publish_bottom_line"));
        this.mCancel = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_question_cancel"));
        this.mPublishTv = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_question_publish"));
        this.mUgcTitle = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_title"));
        this.mTitle = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_question_title"));
        this.mEditImageTextView = (EditImageTextView) findViewById(ResourceUtils.getResIdByName("ugc_content_tv"));
        this.mKeycodeImg = (ImageView) findViewById(ResourceUtils.getResIdByName("ugc_keycode"));
        this.mPhotoEnterImg = (ImageView) findViewById(ResourceUtils.getResIdByName("ugc_pic_entrance"));
        this.mVideoEnterImg = (ImageView) findViewById(ResourceUtils.getResIdByName("ugc_video_entrance"));
        this.mVideoTip = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_question_tip"));
        this.mUploadVideoProgress = findViewById(ResourceUtils.getResIdByName("ugc_question_upload_view"));
        this.mVideoProgressTv = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_question_upload_tv"));
        this.mCloseUploadImg = (ImageView) findViewById(ResourceUtils.getResIdByName("ugc_question_upload_close"));
        this.mTextNumber = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_question_tv_number"));
        UiBaseUtils.setOnClickListener(this.mCancel, this);
        UiBaseUtils.setOnClickListener(this.mPublishTv, this);
        UiBaseUtils.setOnClickListener(this.mKeycodeImg, this);
        UiBaseUtils.setOnClickListener(this.mPhotoEnterImg, this);
        UiBaseUtils.setOnClickListener(this.mVideoEnterImg, this);
        if (this.mEditImageTextView != null) {
            this.mEditImageTextView.setTextChangeListener(this);
        }
        if (!TextUtils.isEmpty(this.placeTitle)) {
            UiBaseUtils.setTextString((TextView) findViewById(ResourceUtils.getResIdByName("ugc_title")), this.placeTitle);
        }
        if (!TextUtils.isEmpty(this.placeHolder) && this.mEditImageTextView != null) {
            this.mEditImageTextView.setHint(this.placeHolder);
        }
        UiBaseUtils.setTextString(this.mTitle, this.title);
        initImageSize();
        if (this.mEditImageTextView != null) {
            this.mEditImageTextView.setRequestImageSize(this.mWidth, this.mHeight);
            this.mEditImageTextView.setPlaceHolder(BitmapFactory.decodeResource(getResources(), R.drawable.ugc_loading_default_pic));
        }
        if (!TextUtils.isEmpty(this.rid)) {
            this.isEdit = true;
            getEditData();
        }
        if (this.mEditImageTextView != null) {
            this.mEditImageTextView.setVideoContentDelListener(this.videoContentDelListener);
        }
        if (this.mRelativeLayout != null) {
            this.mRelativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.4
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (QuestionsPublishActivity.this.mRelativeLayout != null) {
                        QuestionsPublishActivity.this.mRelativeLayout.getWindowVisibleDisplayFrame(rect);
                        int displayHeight = DeviceUtil.ScreenInfo.getDisplayHeight(AppRuntime.getAppContext());
                        int i = rect.bottom - rect.top;
                        int statusBarHeight = DeviceUtil.ScreenInfo.getStatusBarHeight();
                        if (!QuestionsPublishActivity.this.mIsFirstGlobalLayout) {
                            QuestionsPublishActivity.this.mIsFirstGlobalLayout = true;
                            QuestionsPublishActivity.this.mBottomNavigationKeyHeight = (displayHeight - i) - statusBarHeight;
                            if (QuestionsPublishActivity.this.mBottomNavigationKeyHeight < 0) {
                                QuestionsPublishActivity.this.mBottomNavigationKeyHeight = 0;
                            }
                        }
                        QuestionsPublishActivity.this.mInputMethodHeight = ((displayHeight - i) - statusBarHeight) - QuestionsPublishActivity.this.mBottomNavigationKeyHeight;
                        if (ImmersionHelper.SUPPORT_IMMERSION && QuestionsPublishActivity.this.mLastVisibleHeight != i && i > 0) {
                            QuestionsPublishActivity.this.mLastVisibleHeight = i;
                            QuestionsPublishActivity.this.mRelativeLayout.getLayoutParams().height = i;
                            QuestionsPublishActivity.this.mRelativeLayout.requestLayout();
                        }
                    }
                }
            });
        }
    }

    private void updateUiForNightMod() {
        UiBaseUtils.setViewColorResource(this.mRelativeLayout, R.color.ugc_question_reply_rl_bg_color);
        UiBaseUtils.setViewColorResource(this.mHeaderRelativeLayout, R.color.ugc_question_reply_rl_bg_color);
        UiBaseUtils.setViewColorResource(this.mBottomRelativeLayout, R.color.ugc_question_reply_rl_bg_color);
        UiBaseUtils.setTextColorResource(this.mCancel, R.color.ugc_question_reply_cancel_text_color);
        UiBaseUtils.setTextColorResource(this.mUgcTitle, R.color.ugc_question_reply_ugc_title_text_color);
        UiBaseUtils.setTextColorResource(this.mPublishTv, R.color.ugc_publish_no_able_color);
        UiBaseUtils.setTextColorResource(this.mTitle, R.color.ugc_question_reply_title_text_color);
        if (this.mEditImageTextView != null) {
            this.mEditImageTextView.setTextColor(getResources().getColor(R.color.ugc_question_reply_content_text_color));
            this.mEditImageTextView.setHintTextColor(getResources().getColor(R.color.ugc_question_reply_content_hint_text_color));
        }
        UiBaseUtils.setTextColorResource(this.mVideoTip, R.color.ugc_question_reply_video_tip_text_color);
        UiBaseUtils.setViewColorResource(this.mUgcLineView, R.color.ugc_question_reply_line_bg_color);
        UiBaseUtils.setViewColorResource(this.mTitleLineView, R.color.ugc_question_reply_title_line_bg_color);
        UiBaseUtils.setViewColorResource(this.mBottomLineView, R.color.ugc_question_reply_bottom_line_bg_color);
        UiBaseUtils.setViewColorResource(this.mUploadVideoProgress, R.color.ugc_question_reply_upload_video_bg_color);
        UiBaseUtils.setTextColorResource(this.mVideoProgressTv, R.color.ugc_question_reply_upload_video_progress_text_color);
        UiBaseUtils.setImageResource(this.mCloseUploadImg, R.drawable.ugc_question_upload_close);
        UiBaseUtils.setTextColorResource(this.mTextNumber, R.color.ugc_album_layer_text_color);
    }

    private void initGuideTips() {
        if (!UgcSharePrefsUtils.getValue(UgcUBCUtils.QUESTION_REPLY_PAGE)) {
            UiBaseUtils.setVisibility(this.mVideoTip, 0);
            UgcSharePrefsUtils.commit(UgcUBCUtils.QUESTION_REPLY_PAGE);
            UiBaseUtils.setOnClickListener(this.mVideoTip, new View.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UiBaseUtils.setVisibility(QuestionsPublishActivity.this.mVideoTip, 8);
                }
            });
            UiBaseUtils.runPostDelayed(this.mVideoTip, new Runnable() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    UiBaseUtils.setVisibility(QuestionsPublishActivity.this.mVideoTip, 8);
                }
            }, 7000L);
        }
    }

    private void getEditData() {
        if (!NetWorkUtils.isNetworkConnected(this)) {
            UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_preview_toast_no_network).showToast();
            return;
        }
        showLoading(getResources().getString(R.string.waiting_loading_tip));
        new QuestionResponseModel().getEditContent(this.qid, this.rid, new QuestionResponseModel.QuestionEditCallback() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.7
            @Override // com.baidu.searchbox.ugc.model.QuestionResponseModel.QuestionEditCallback
            public void onSuccess(List<QuestionResponseModel.ReplyContentModel> list) {
                if (list != null && list.size() > 0) {
                    QuestionsPublishActivity.this.isEdit = true;
                    if (QuestionsPublishActivity.this.mEditImageTextView != null) {
                        QuestionsPublishActivity.this.mEditImageTextView.setContentData(list);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            if ("image".equals(list.get(i2).type) && list.get(i2).data != null && list.get(i2).data.origin != null) {
                                QuestionsPublishActivity.this.imageUrlList.add(list.get(i2).data.origin.src);
                            }
                            i = i2 + 1;
                        }
                        if (QuestionsPublishActivity.this.mEditImageTextView.getText() != null && !TextUtils.isEmpty(QuestionsPublishActivity.this.mEditImageTextView.getText().toString())) {
                            QuestionsPublishActivity.this.setAbleClick();
                            QuestionsPublishActivity.this.setEdittextSelectionInEnd(500L);
                        }
                    }
                }
                QuestionsPublishActivity.this.hideLoading();
            }

            @Override // com.baidu.searchbox.ugc.model.QuestionResponseModel.QuestionEditCallback
            public void onFailed(String str) {
                QuestionsPublishActivity.this.hideLoading();
            }
        });
    }

    private ArrayList<String> getImageUrlList() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.mEditImageTextView != null) {
            EditImageTextView editImageTextView = this.mEditImageTextView;
            ArrayList<String> editTextPic = EditImageTextView.getEditTextPic(this.mEditImageTextView.getText().toString());
            for (int i = 0; i < editTextPic.size(); i++) {
                if (!this.imageUrlList.contains(editTextPic.get(i))) {
                    arrayList.add(editTextPic.get(i));
                    this.indexList.add(Integer.valueOf(i));
                }
            }
        }
        return arrayList;
    }

    public void setBottomEntrUnableClick() {
        UiBaseUtils.setClickable(this.mKeycodeImg, false);
        UiBaseUtils.setClickable(this.mPhotoEnterImg, false);
        UiBaseUtils.setClickable(this.mVideoEnterImg, false);
    }

    public void setBottomEntrAbleClick() {
        UiBaseUtils.setClickable(this.mKeycodeImg, true);
        UiBaseUtils.setClickable(this.mPhotoEnterImg, true);
        UiBaseUtils.setClickable(this.mVideoEnterImg, true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == ResourceUtils.getResIdByName("ugc_keycode")) {
            if (UgcUiUtils.isSoftShowing(this)) {
                hideInput(this.mEditImageTextView);
            } else {
                showInput(this.mEditImageTextView);
            }
        } else if (id == ResourceUtils.getResIdByName("ugc_pic_entrance")) {
            if (this.mVideoTip != null && this.mVideoTip.getVisibility() == 0) {
                UiBaseUtils.setVisibility(this.mVideoTip, 8);
            }
            if (this.mEditImageTextView != null) {
                EditImageTextView editImageTextView = this.mEditImageTextView;
                if (EditImageTextView.getEditTextPic(this.mEditImageTextView.getText().toString()).size() >= 30) {
                    UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_question_most_select_photos_tip).showToast();
                    return;
                }
            }
            UgcUBCUtils.answerStatistics(UgcUBCUtils.UGC_TYPE_PHOTO_CLICK);
            if (UgcUiUtils.isSoftShowing(this)) {
                hideInput(this.mEditImageTextView);
            }
            SelectUtil.clear();
            SelectUtil.isWenda(true);
            Intent intent = new Intent(this, LocalAlbumActivity.class);
            this.answerInfo.from = 0;
            this.answerInfo.supportSingleSelect = true;
            intent.putExtra("data", this.answerInfo);
            startActivityForResult(intent, LOCAL_ALBUM_CODE);
        } else if (id == R.id.ugc_video_entrance) {
            if (this.mVideoTip.getVisibility() == 0) {
                this.mVideoTip.setVisibility(8);
            }
            if (this.mEditImageTextView.hasVideo(this.mEditImageTextView.getText().toString())) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_question_video_more_tips).showToast();
                return;
            }
            if (UgcUiUtils.isSoftShowing(this)) {
                hideInput(this.mEditImageTextView);
            }
            UgcUBCUtils.answerStatistics("video_click");
            this.answerInfo.launchFrom = "publish";
            IPublisherSboxVideoInterface iPublisherSboxVideoInterface = (IPublisherSboxVideoInterface) c.a(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
            if (iPublisherSboxVideoInterface != null) {
                iPublisherSboxVideoInterface.invokeVideoCapture(this.answerInfo, this);
            }
        } else if (id == ResourceUtils.getResIdByName("ugc_question_publish")) {
            if (this.mEnableClick) {
                if (!NetWorkUtils.isNetworkConnected(this)) {
                    UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_preview_toast_no_network).showToast();
                    return;
                }
                setUnableClick();
                if (this.mEditImageTextView != null) {
                    this.mEditTextContent = this.mEditImageTextView.getText().toString();
                }
                String str = this.answerInfo == null ? "" : this.answerInfo.sourceFrom;
                if (!UgcLoginUtils.isLogin()) {
                    UgcLoginUtils.login(new ILoginResultListener() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.8
                        @Override // com.baidu.searchbox.account.ILoginResultListener
                        public void onResult(int i) {
                            if (i == 0) {
                                QuestionsPublishActivity.this.goPublish();
                            }
                        }
                    }, UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, str);
                    Sender.sendBroadcast(AppRuntime.getAppContext(), "com.baidu.channel.wenda.login_success", "wenda_detail");
                } else if (!UgcLoginUtils.isGuestLogin()) {
                    goPublish();
                } else {
                    UgcLoginUtils.bindPhone(new ILoginResultListener() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.9
                        @Override // com.baidu.searchbox.account.ILoginResultListener
                        public void onResult(int i) {
                            if (i == 0) {
                                QuestionsPublishActivity.this.goPublish();
                            }
                        }
                    }, UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, str);
                }
                UgcUBCUtils.answerStatistics(UgcUBCUtils.UGC_TYPE_PUBLISH_CLICK);
            }
        } else if (id == ResourceUtils.getResIdByName("ugc_question_cancel")) {
            backDispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goPublish() {
        if (this.isEdit) {
            if (getImageUrlList().size() > 0) {
                startUploadImages(getImageUrlList(), 0);
                return;
            } else {
                publish(this.mEditTextContent);
                return;
            }
        }
        if (this.mEditImageTextView != null) {
            EditImageTextView editImageTextView = this.mEditImageTextView;
            if (EditImageTextView.getEditTextPic(this.mEditTextContent).size() > 0) {
                EditImageTextView editImageTextView2 = this.mEditImageTextView;
                startUploadImages(EditImageTextView.getEditTextPic(this.mEditTextContent), 0);
                return;
            }
        }
        publish(this.mEditTextContent);
    }

    @Override // com.baidu.searchbox.appframework.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !this.mIsImageUploadding) {
            backDispose();
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void backDispose() {
        if (!this.mIsImageUploadding) {
            String str = null;
            if (this.mEditImageTextView != null) {
                str = this.mEditImageTextView.getText().toString().trim();
            }
            String generateSPKey = DraftUtils.generateSPKey(UgcLoginUtils.getUK(), "6", this.qid);
            String string = DraftSPWrapper.getInstance().getString(generateSPKey, "");
            if (!TextUtils.isEmpty(str) && str.length() > 0 && !TextUtils.equals(str, string) && !this.mIsVideoUploadding) {
                showSaveDraftDialog(str, generateSPKey);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                cleanDraft(generateSPKey);
            }
            UgcUBCUtils.saveDraftPublishUbcStatistics(this.sourceFrom, false, false, false, true);
            UgcUBCUtils.exitAnswerPage(UgcUBCUtils.UGC_TIME_CANCEL);
            finish();
        }
    }

    private void showSaveDraftDialog(final String str, final String str2) {
        UgcDialogUtils.showSaveDraftDialog(new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                DraftSPWrapper.getInstance().putString(str2, str);
                QuestionsPublishActivity.this.saveDraftTimeInfo(str2);
                UgcUBCUtils.saveDraftPublishUbcStatistics(QuestionsPublishActivity.this.sourceFrom, false, true, true, true);
                QuestionsPublishActivity.this.finish();
            }
        }, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                QuestionsPublishActivity.this.cleanDraft(str2);
                UgcUBCUtils.exitAnswerPage(UgcUBCUtils.UGC_TIME_CANCEL);
                UgcUBCUtils.saveDraftPublishUbcStatistics(QuestionsPublishActivity.this.sourceFrom, false, true, false, true);
                QuestionsPublishActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveDraftTimeInfo(String str) {
        String string = DraftSPWrapper.getInstance().getString(QUESTION_DRAFT_TIMEOUT_INFO_SP_KEY, "");
        JSONObject jSONObject = null;
        try {
            if (TextUtils.isEmpty(string)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(string);
            }
            if (jSONObject != null) {
                jSONObject.put(str, Long.toString(System.currentTimeMillis()));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d(TAG, "QuestionsPbActivity e.toString() " + e.toString());
            }
        }
        if (jSONObject != null) {
            DraftSPWrapper.getInstance().putString(QUESTION_DRAFT_TIMEOUT_INFO_SP_KEY, jSONObject.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void cleanDraftTimeInfo(String str) {
        JSONObject jSONObject;
        String string = DraftSPWrapper.getInstance().getString(QUESTION_DRAFT_TIMEOUT_INFO_SP_KEY, "");
        try {
        } catch (JSONException e) {
            e = e;
            jSONObject = null;
        }
        if (!TextUtils.isEmpty(string)) {
            jSONObject = new JSONObject(string);
            try {
                jSONObject.remove(str);
            } catch (JSONException e2) {
                e = e2;
                if (DEBUG) {
                    Log.d(TAG, "QuestionsPbActivity e.toString() " + e.toString());
                }
                if (jSONObject == null) {
                }
            }
            if (jSONObject == null) {
                DraftSPWrapper.getInstance().putString(QUESTION_DRAFT_TIMEOUT_INFO_SP_KEY, jSONObject.toString());
            }
        }
    }

    private void initImageSize() {
        int dp2px = getResources().getDisplayMetrics().widthPixels - (DeviceUtil.ScreenInfo.dp2px(this, 15.0f) * 2);
        this.mHeight = DeviceUtil.ScreenInfo.dp2px(this, 185.0f);
        this.mWidth = dp2px;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == LOCAL_ALBUM_CODE && i2 == -1 && SelectUtil.getSeletedImages().size() != 0) {
            String str = SelectUtil.getSeletedImages().get(0).uriStr;
            if (this.mEditImageTextView != null) {
                if (SelectUtil.isGif(str)) {
                    this.mEditImageTextView.insertImage(str, ImageHelper.createBitmapThumbnail(str, this.mMaxBitmapSize, this.mMaxBitmapSize), 3);
                } else {
                    this.mEditImageTextView.insertImage(str, ImageHelper.createBitmapThumbnail(str, this.mMaxBitmapSize, this.mMaxBitmapSize), 2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoInfo(StartPublishEvent startPublishEvent) {
        String saveBitmap = com.baidu.searchbox.ugc.utils.FileUtils.saveBitmap(com.baidu.searchbox.ugc.utils.FileUtils.getLocalVideoBitmap(startPublishEvent.videoPath));
        if (!TextUtils.isEmpty(this.mVideoCover)) {
            saveBitmap = this.mVideoCover;
        }
        if (this.mEditImageTextView.hasVideo(this.mEditImageTextView.getText().toString())) {
            this.mEditImageTextView.deleteVideo();
        }
        this.mEditImageTextView.insertImage(startPublishEvent.videoPath, ImageHelper.createBitmapThumbnail(saveBitmap, this.mMaxBitmapSize, this.mMaxBitmapSize), 5);
        startUploadVideo(startPublishEvent.videoPath);
    }

    private void registerEvent() {
        EventBusWrapper.registerOnMainThread(this, StartPublishEvent.class, new b<StartPublishEvent>() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(final StartPublishEvent startPublishEvent) {
                if (startPublishEvent != null) {
                    QuestionsPublishActivity.this.mVideoPath = startPublishEvent.videoPath;
                    String str = QuestionsPublishActivity.this.answerInfo == null ? "" : QuestionsPublishActivity.this.answerInfo.sourceFrom;
                    if (!UgcLoginUtils.isLogin()) {
                        UgcLoginUtils.login(new ILoginResultListener() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.12.1
                            @Override // com.baidu.searchbox.account.ILoginResultListener
                            public void onResult(int i) {
                                if (i == 0) {
                                    QuestionsPublishActivity.this.updateVideoInfo(startPublishEvent);
                                    Sender.sendBroadcast(AppRuntime.getAppContext(), "com.baidu.channel.wenda.login_success", "wenda_detail");
                                }
                            }
                        }, UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, str);
                    } else if (!UgcLoginUtils.isGuestLogin()) {
                        QuestionsPublishActivity.this.updateVideoInfo(startPublishEvent);
                    } else {
                        UgcLoginUtils.bindPhone(new ILoginResultListener() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.12.2
                            @Override // com.baidu.searchbox.account.ILoginResultListener
                            public void onResult(int i) {
                                if (i == 0) {
                                    QuestionsPublishActivity.this.updateVideoInfo(startPublishEvent);
                                    Sender.sendBroadcast(AppRuntime.getAppContext(), "com.baidu.channel.wenda.login_success", "wenda_detail");
                                }
                            }
                        }, UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, str);
                    }
                }
            }
        });
        EventBusWrapper.registerOnMainThread(this, UpdateVideoCoverEvent.class, new b<UpdateVideoCoverEvent>() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(UpdateVideoCoverEvent updateVideoCoverEvent) {
                if (updateVideoCoverEvent != null) {
                    QuestionsPublishActivity.this.mVideoCover = updateVideoCoverEvent.videoCover;
                    if (!TextUtils.isEmpty(QuestionsPublishActivity.this.mVideoPath) && !TextUtils.isEmpty(QuestionsPublishActivity.this.mVideoCover) && UgcLoginUtils.isLogin()) {
                        if (QuestionsPublishActivity.this.mEditImageTextView.hasVideo(QuestionsPublishActivity.this.mEditImageTextView.getText().toString())) {
                            QuestionsPublishActivity.this.mEditImageTextView.deleteVideo();
                        }
                        QuestionsPublishActivity.this.mEditImageTextView.insertImage(QuestionsPublishActivity.this.mVideoPath, ImageHelper.createBitmapThumbnail(QuestionsPublishActivity.this.mVideoCover, QuestionsPublishActivity.this.mMaxBitmapSize, QuestionsPublishActivity.this.mMaxBitmapSize), 5);
                        QuestionsPublishActivity.this.startUploadCover(QuestionsPublishActivity.this.mVideoCover);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUploadCover(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        String saveBitmap = com.baidu.searchbox.ugc.utils.FileUtils.saveBitmap(com.baidu.searchbox.ugc.utils.FileUtils.getLocalVideoBitmap(str));
        if (saveBitmap != null) {
            arrayList.add(saveBitmap);
            startUploadImages(arrayList, 1);
        }
    }

    private void startUploadImages(ArrayList<String> arrayList, final int i) {
        if (!NetWorkUtils.isNetworkConnected(this)) {
            UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_preview_toast_no_network).showToast();
            return;
        }
        this.mIsImageUploadding = true;
        setBottomEntrUnableClick();
        this.mIndex = 0;
        final int size = arrayList.size();
        if (i == 0 && !this.isEdit) {
            this.uploadPic = new ArrayList<>();
        } else {
            this.hashMap = new HashMap<>();
        }
        if (i != 1) {
            showLoading(getResources().getString(R.string.ugc_upload_tips));
        }
        UploadManager.getInstance().setUploadCallback(new UploadManager.UploadCallback() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.14
            @Override // com.baidu.searchbox.ugc.upload.UploadManager.UploadCallback
            public void onError(String str) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_release_fail).showToast();
                QuestionsPublishActivity.this.setAbleClick();
                QuestionsPublishActivity.this.mIsImageUploadding = false;
                QuestionsPublishActivity.this.setBottomEntrAbleClick();
                QuestionsPublishActivity.this.hideLoading();
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onProgress(UploadFileTask uploadFileTask, long j, long j2) {
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onStart(UploadFileTask uploadFileTask) {
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onSuccess(UploadFileTask uploadFileTask) {
                if (i != 1) {
                    if (!QuestionsPublishActivity.this.isEdit) {
                        QuestionsPublishActivity.this.uploadPic.add(uploadFileTask.getUrl());
                    } else {
                        QuestionsPublishActivity.this.hashMap.put(QuestionsPublishActivity.this.indexList.get(QuestionsPublishActivity.this.mIndex), uploadFileTask.getUrl());
                    }
                    QuestionsPublishActivity.access$2808(QuestionsPublishActivity.this);
                    if (QuestionsPublishActivity.this.mIndex == size) {
                        String str = "";
                        if (QuestionsPublishActivity.this.mEditImageTextView != null) {
                            if (!QuestionsPublishActivity.this.isEdit) {
                                EditImageTextView unused = QuestionsPublishActivity.this.mEditImageTextView;
                                str = EditImageTextView.replaceLocalUrl(QuestionsPublishActivity.this.mEditTextContent, QuestionsPublishActivity.this.uploadPic);
                            } else {
                                str = QuestionsPublishActivity.this.mEditImageTextView.replaceNewImageUrl(QuestionsPublishActivity.this.mEditTextContent, QuestionsPublishActivity.this.hashMap);
                            }
                        }
                        QuestionsPublishActivity.this.publish(str);
                    }
                } else {
                    HttpRequestPublishModule.VideoUploadModel videoUploadInfo = HttpRequestPublishModule.getVideoUploadInfo();
                    videoUploadInfo.coverUrl = uploadFileTask.getUrl();
                    videoUploadInfo.mediaId = QuestionsPublishActivity.this.mMediaId;
                    if (QuestionsPublishActivity.this.mEditImageTextView != null) {
                        QuestionsPublishActivity questionsPublishActivity = QuestionsPublishActivity.this;
                        EditImageTextView unused2 = QuestionsPublishActivity.this.mEditImageTextView;
                        questionsPublishActivity.mVideoLabel = EditImageTextView.compileVideoContent(videoUploadInfo);
                    }
                    QuestionsPublishActivity.this.saveVideoDraftInfo(QuestionsPublishActivity.this.qid, QuestionsPublishActivity.this.mVideoLabel, uploadFileTask.getUrl());
                    QuestionsPublishActivity.this.setAbleClick();
                    QuestionsPublishActivity.this.mIsImageUploadding = false;
                    QuestionsPublishActivity.this.setBottomEntrAbleClick();
                    QuestionsPublishActivity.this.hideLoading();
                }
                com.baidu.searchbox.ugc.utils.FileUtils.deleteCoverFile(new File(Environment.getExternalStorageDirectory().getPath() + com.baidu.searchbox.ugc.utils.FileUtils.VIDEOCOVER));
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onFailed(UploadFileTask uploadFileTask) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_release_fail).showToast();
                if (i == 1) {
                    QuestionsPublishActivity.this.setAbleClick();
                }
            }
        });
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(new UploadImageTask(arrayList.get(i2)));
        }
        UploadManager.getInstance().startAll(arrayList2, 0, "ugc");
    }

    private void startUploadVideo(final String str) {
        Runnable uploadVideoTask;
        if (this.mCloseUploadImg != null && this.mCloseUploadImg.getVisibility() == 0) {
            this.mCloseUploadImg.setVisibility(8);
        }
        UploadManager.getInstance().setUploadCallback(new UploadManager.UploadCallback() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.15
            @Override // com.baidu.searchbox.ugc.upload.UploadManager.UploadCallback
            public void onError(String str2) {
                QuestionsPublishActivity.this.mIsSuccess = false;
                QuestionsPublishActivity.this.mIsVideoUploadding = false;
                QuestionsPublishActivity.this.UpdateUploadFail(str);
                if (QuestionsPublishActivity.this.mEditImageTextView == null || !QuestionsPublishActivity.this.mEditImageTextView.onlyHasVideoContent()) {
                    if (QuestionsPublishActivity.this.mEditImageTextView != null && QuestionsPublishActivity.this.mEditImageTextView.getText() != null) {
                        QuestionsPublishActivity.this.updatePubStatus(QuestionsPublishActivity.this.mEditImageTextView.getText().toString());
                        return;
                    }
                    return;
                }
                QuestionsPublishActivity.this.setUnableClick();
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onProgress(UploadFileTask uploadFileTask, long j, long j2) {
                QuestionsPublishActivity.this.updateProgress(j);
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onStart(UploadFileTask uploadFileTask) {
                QuestionsPublishActivity.this.mUploadVideoProgress.setVisibility(0);
                QuestionsPublishActivity.this.mIsVideoUploadding = true;
                QuestionsPublishActivity.this.mUploadVideoProgress.postDelayed(new Runnable() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QuestionsPublishActivity.this.setUnableClick();
                    }
                }, 180L);
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onSuccess(UploadFileTask uploadFileTask) {
                QuestionsPublishActivity.this.mMediaId = uploadFileTask.getUrl();
                QuestionsPublishActivity.this.mSourceKey = uploadFileTask.getBosKey();
                QuestionsPublishActivity.this.setVideoUploadEnd();
                QuestionsPublishActivity.this.mIsSuccess = true;
                QuestionsPublishActivity.this.mIsVideoUploadding = false;
                QuestionsPublishActivity.this.startUploadCover(str);
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onFailed(UploadFileTask uploadFileTask) {
                if (QuestionsPublishActivity.this.mEditImageTextView != null && QuestionsPublishActivity.this.mEditImageTextView.getText() != null) {
                    QuestionsPublishActivity.this.updatePubStatus(QuestionsPublishActivity.this.mEditImageTextView.getText().toString());
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        IPublisherSboxVideoInterface iPublisherSboxVideoInterface = (IPublisherSboxVideoInterface) c.a(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
        if (iPublisherSboxVideoInterface != null && (uploadVideoTask = iPublisherSboxVideoInterface.getUploadVideoTask(str)) != null && (uploadVideoTask instanceof UploadFileTask)) {
            arrayList.add((UploadFileTask) uploadVideoTask);
        }
        UploadManager.getInstance().startAll(arrayList, 0, "ugc");
    }

    private void showLoading(String str) {
        if (isFinishing()) {
            return;
        }
        if (this.mBdProgressDialog == null || !this.mBdProgressDialog.isShowing()) {
            this.mBdProgressDialog = new BdProgressDialog(this, str);
            this.mBdProgressDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        if (this.mBdProgressDialog != null) {
            this.mBdProgressDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publish(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replaceAll("\n", "<br />");
        }
        if (!TextUtils.isEmpty(this.mVideoLabel)) {
            str = replaceVideoContent(str);
        }
        JSONObject jSONObject = new JSONObject();
        PublishRequestModel publishRequestModel = new PublishRequestModel();
        publishRequestModel.data = jSONObject;
        publishRequestModel.inputStr = str;
        publishRequestModel.postUrl = this.postUrl;
        publishRequestModel.sourceFrom = this.sourceFrom;
        publishRequestModel.extObject = this.extInfo;
        publishRequestModel.publishType = this.answerInfo.publishType;
        final JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("qid", this.qid);
            jSONObject2.put("rid", this.rid);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        publishRequestModel.questionReply = jSONObject2;
        PublishRequestManager.getInstance().publishRequest(publishRequestModel, new PublishRequestManager.PublishRequestCallback() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.16
            @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
            public void onSuccess(PublishModels.PublishResultInfo publishResultInfo) {
                QuestionsPublishActivity.this.handleDraftData(true);
                Sender.sendBroadcast(AppRuntime.getAppContext(), "com.baidu.channel.wenda.answer_finish", jSONObject2.toString());
                String str2 = null;
                if (publishResultInfo != null && publishResultInfo.data != null) {
                    str2 = publishResultInfo.data.errmsg;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = QuestionsPublishActivity.this.getString(R.string.ugc_release_success);
                }
                UniversalToast.makeText(AppRuntime.getAppContext(), str2).showToast();
                UgcUBCUtils.exitAnswerPage(UgcUBCUtils.UGC_TIME_PUB);
                QuestionsPublishActivity.this.mIsImageUploadding = false;
                QuestionsPublishActivity.this.setBottomEntrAbleClick();
                QuestionsPublishActivity.this.hideLoading();
                QuestionsPublishActivity.this.finish();
            }

            @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
            public void onFailed(String str2) {
                QuestionsPublishActivity.this.setAbleClick();
                if (TextUtils.isEmpty(str2)) {
                    str2 = QuestionsPublishActivity.this.getString(R.string.ugc_release_fail);
                }
                UniversalToast.makeText(AppRuntime.getAppContext(), str2).showToast();
                QuestionsPublishActivity.this.mIsImageUploadding = false;
                QuestionsPublishActivity.this.setBottomEntrAbleClick();
                QuestionsPublishActivity.this.hideLoading();
            }
        });
    }

    private String replaceVideoContent(String str) {
        return str.replaceAll("<video.+></video>", this.mVideoLabel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(long j) {
        if (j <= 100) {
            UiBaseUtils.setTextString(this.mVideoProgressTv, String.format(getResources().getString(R.string.ugc_question_upload_progress_string), Long.valueOf(j)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoUploadEnd() {
        UiBaseUtils.setVisibility(this.mUploadVideoProgress, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UpdateUploadFail(String str) {
        String string = getResources().getString(R.string.ugc_question_upload_error_tip);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.ugc_question_reply_reupload_video_text_color)), string.indexOf(getString(R.string.ugc_question_reload)), string.length(), 33);
        spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.17
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
                textPaint.clearShadowLayer();
            }
        }, string.indexOf(getString(R.string.ugc_question_reload)), string.length(), 33);
        if (this.mVideoProgressTv != null) {
            this.mVideoProgressTv.setText(spannableString);
            this.mVideoProgressTv.setMovementMethod(LinkMovementMethod.getInstance());
        }
        UiBaseUtils.setVisibility(this.mCloseUploadImg, 0);
        UiBaseUtils.setOnClickListener(this.mCloseUploadImg, new View.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogUtils.showDialog(R.string.ugc_question_delete_video_prompt, R.string.ugc_question_delete_video_tips, R.string.ugc_question_confirm_delete, R.string.ugc_publish_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.18.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        UiBaseUtils.setVisibility(QuestionsPublishActivity.this.mUploadVideoProgress, 8);
                        if (QuestionsPublishActivity.this.mEditImageTextView != null) {
                            QuestionsPublishActivity.this.mEditImageTextView.deleteVideo();
                        }
                    }
                }, (DialogInterface.OnClickListener) null);
            }
        });
    }

    private void avoidHintColor(View view) {
        if (view instanceof TextView) {
            ((TextView) view).setHighlightColor(getResources().getColor(17170445));
        }
    }

    public void showInput(final View view) {
        if (this.mEditImageTextView != null) {
            this.mBottomRelativeLayout.setVisibility(8);
            this.mEditImageTextView.requestFocus();
            this.mEditImageTextView.postDelayed(new Runnable() { // from class: com.baidu.searchbox.ugc.activity.QuestionsPublishActivity.19
                @Override // java.lang.Runnable
                public void run() {
                    ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(view, 0);
                    QuestionsPublishActivity.this.mBottomRelativeLayout.setVisibility(0);
                }
            }, 300L);
        }
    }

    public void hideInput(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && view != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SelectUtil.clear();
        EventBusWrapper.unregister(this);
        UploadManager.getInstance().release();
    }

    private ArrayList<ImageView> getImageList() {
        ArrayList<ImageView> arrayList = new ArrayList<>();
        arrayList.add(this.mKeycodeImg);
        arrayList.add(this.mPhotoEnterImg);
        arrayList.add(this.mVideoEnterImg);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUnableClick() {
        this.mEnableClick = false;
        UgcUiUtils.setTextResource(this.mPublishTv, R.color.ugc_publish_no_able_color);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAbleClick() {
        if (!this.mIsVideoUploadding) {
            this.mEnableClick = true;
            UgcUiUtils.setTextResource(this.mPublishTv, R.color.ugc_publish_action_color);
        }
    }

    @Override // com.baidu.searchbox.ugc.view.EditImageTextView.TextNumbersChangedListener
    public void textChange(String str) {
        updatePubStatus(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePubStatus(String str) {
        if (TextUtils.isEmpty(str)) {
            setUnableClick();
            UiBaseUtils.setTextString(this.mTextNumber, "0/8000");
            return;
        }
        int length = str.replaceAll("<img.+/>", "").replaceAll("<video.+></video>", "").trim().length();
        UiBaseUtils.setTextString(this.mTextNumber, length + "/8000");
        if (str.trim().length() > 0 && length <= 8000) {
            if (!this.mIsVideoUploadding) {
                setAbleClick();
            }
            UgcUiUtils.setTextResource(this.mTextNumber, R.color.ugc_album_layer_text_color);
        } else if (length > 8000) {
            setUnableClick();
            UgcUiUtils.setTextResource(this.mTextNumber, R.color.ugc_red);
        } else if (str.trim().length() == 0) {
            setUnableClick();
            UgcUiUtils.setTextResource(this.mTextNumber, R.color.ugc_album_layer_text_color);
        }
    }
}
