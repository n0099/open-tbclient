package com.baidu.searchbox.wordscommand;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.android.ext.widget.dialog.BdDialog;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.util.android.WrappedClipboardManager;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.behavior.record.api.IBehaviorApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.appframework.SimpleActivityLifeCycle;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.permission.DangerousPermissionManager;
import com.baidu.searchbox.permission.DangerousPermissionUtils;
import com.baidu.searchbox.security.WarmTipsManager;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.wordscommand.bussiness.InvokeParamsManager;
import com.baidu.searchbox.wordscommand.data.CommandContent;
import com.baidu.searchbox.wordscommand.data.CommandToken;
import com.baidu.searchbox.wordscommand.event.WordCommandEvent;
import com.baidu.searchbox.wordscommand.listener.ICommandListener;
import com.baidu.searchbox.wordscommand.listener.IGetCommandContentListener;
import com.baidu.searchbox.wordscommand.listener.IGetCommonTokenListener;
import com.baidu.searchbox.wordscommand.listener.PictureCommandInvokeCallBack;
import com.baidu.searchbox.wordscommand.listener.WordCommandProcessCallback;
import com.baidu.searchbox.wordscommand.request.WordCommandRequest;
import com.baidu.searchbox.wordscommand.runtime.IWordCommandApp;
import com.baidu.searchbox.wordscommand.runtime.WordCommandRuntime;
import com.baidu.searchbox.wordscommand.util.CommandException;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.searchbox.wordscommand.util.CommandUtil;
import com.baidu.searchbox.wordscommand.util.InvokeParamsSpUtil;
import com.baidu.searchbox.wordscommand.util.SimpleLifecycleCallback;
import com.baidu.tieba.b40;
import com.baidu.tieba.c40;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class WordCommandManager {
    public static final String BEHAVIOR_SCENES_ID = "basic";
    public static final String CLEAR_TOKEN_DATA_SP_KEY = "token_clear_switch_data";
    public static final String DCIM = "/DCIM";
    public static final String DEFAULT_DECODE_REGEX = "\\^[#$a-zA-Z0-9]{10}\\^";
    public static final String DEFAULT_DECODE_REGEX_ZH = "^(\\d+\\.[\\d\\w]+:/{1,2})?[嘻哈哦嘟嘛吧呢][一-龥]{10}[嘻哈哦嘟嘛吧呢]";
    public static final String DEFAULT_VALUE = "0";
    public static final int DELAY_REMOVE_CLIP_LISTENER = 5000;
    public static final String DESC = " DESC";
    public static final String IMAGE_COMMAND_TYPE = "1";
    public static final String IMAGE_JPEG = "image/jpeg";
    public static final String IMAGE_PNG = "image/png";
    public static final String KEY_CONTENT = "content";
    public static final String KEY_IMAGE_SAVE = "img_save";
    public static final String KEY_KEY = "key";
    public static final String KEY_TEXT = "text";
    public static final String KEY_TITLE = "title";
    public static final String KEY_TK = "__tk__";
    public static final String KEY_TYPE = "type";
    public static final String PIC_COMMAND_IS_OPEN_KEY = "pic_command_is_open";
    public static final String PIC_ENABLE_VALUE = "1";
    public static final String RECENT_SUCCESS_PIC_COMMAND_PATH = "KEY_RECENT_PIC_PATH";
    public static final String TAG = "WordCommandManager";
    public static final String TEXT_COMMAND_TYPE = "0";
    public static final int TIME_SPAN_IMAGE_CODE_CHECK_MINUTES = 5;
    public static final String TOKEN_REGEX_DATA_SP_KEY = "word_command_token_regex_data";
    public static final String TOKEN_REGEX_ZH_DATA_SP_KEY = "word_command_token_regex_zh_data";
    public static final String VALUE_FIRST_INVOKE_BY_KOULING = "1";
    public static final String VALUE_NOT_FIRST_INVOKE_BY_KOULING = "0";
    public static final String WORD_COMMAND_PRESET_REGEX = "XF5bIyRhLXpBLVowLTldezEwfVxe";
    public static final String WORD_COMMAND_TYPE = "0";
    public static String sDecodeCommandActivityId;
    public static JSONObject sDecodeCommandUbcLogExt;
    public static volatile WordCommandManager sInstance;
    public static boolean sIsOnInitialUIReady;
    public static String sShareCommandActivityId;
    public ClipboardManager.OnPrimaryClipChangedListener mClipChangedListener;
    public ClipboardManager mClipboardManager;
    public ICommandListener mIBaiduListener;
    public String mUBCClipboardString;
    public long mUBCDispatchStartTime;
    public long mUBCShareTokenStartTime;
    public static final boolean DEBUG = WordCommandRuntime.DEBUG;
    public static String mOneselfShareString = null;
    public static String mOneselfSharePictureCommand = null;
    public static final String[] WORD_COMMAND_PERMISSIONS = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    public String mRecentImagePath = "";
    public String mTitleString = null;
    public String mContentString = null;
    public final SharedPrefsWrapper mSharedPrefsWrapper = new SharedPrefsWrapper("");
    public final WrappedClipboardManager mWrappedClipboardManager = WrappedClipboardManager.newInstance(AppRuntime.getAppContext());

    /* loaded from: classes4.dex */
    public class BuildDialogCancelListener implements BdAlertDialog.OnItemClickListener {
        public BuildDialogCancelListener() {
        }

        @Override // com.baidu.android.ext.widget.dialog.BdAlertDialog.OnItemClickListener
        public void onItemClick(View view2) {
            if (WordCommandManager.this.mIBaiduListener != null) {
                WordCommandManager.this.mIBaiduListener.onCancel();
                WordCommandManager.this.mIBaiduListener = null;
            }
            CommandUBCHelper.executeWordCommandUbcStatistics(CommandUBCHelper.WORD_COMMAND_BUILD_DIALOG, "click", "cancel", WordCommandManager.sShareCommandActivityId, null);
        }
    }

    /* loaded from: classes4.dex */
    public class BuildDialogConfirmListener implements BdAlertDialog.OnItemClickListener {
        public final String mBoxWordCommandStr;

        public BuildDialogConfirmListener(String str) {
            this.mBoxWordCommandStr = str;
        }

        @Override // com.baidu.android.ext.widget.dialog.BdAlertDialog.OnItemClickListener
        public void onItemClick(View view2) {
            WordCommandManager.this.setClipboardText(this.mBoxWordCommandStr);
            WordCommandManager.this.onComplete();
            CommandUBCHelper.executeWordCommandUbcStatistics(CommandUBCHelper.WORD_COMMAND_BUILD_DIALOG, "click", CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_PASTE, WordCommandManager.sShareCommandActivityId, null);
        }
    }

    /* loaded from: classes4.dex */
    public static class ParseDialogCancelListener implements BdDialog.OnItemClickListener {
        public ParseDialogCancelListener() {
        }

        @Override // com.baidu.android.ext.widget.dialog.BdDialog.OnItemClickListener
        public void onItemClick(View view2) {
            CommandUBCHelper.executeWordCommandUbcStatistics(CommandUBCHelper.WORD_COMMAND_PARSE_DIALOG, "click", "cancel", WordCommandManager.sDecodeCommandActivityId, WordCommandManager.sDecodeCommandUbcLogExt);
        }
    }

    /* loaded from: classes4.dex */
    public static class ParseDialogConfirmListener implements BdDialog.OnItemClickListener {
        public final String schemeUrl;

        public ParseDialogConfirmListener(String str) {
            this.schemeUrl = str;
        }

        @Override // com.baidu.android.ext.widget.dialog.BdDialog.OnItemClickListener
        public void onItemClick(View view2) {
            IWordCommandApp.Impl.get().schemeInvoke(this.schemeUrl);
            CommandUBCHelper.executeWordCommandUbcStatistics(CommandUBCHelper.WORD_COMMAND_PARSE_DIALOG, "click", "view", WordCommandManager.sDecodeCommandActivityId, WordCommandManager.sDecodeCommandUbcLogExt);
        }
    }

    public static /* synthetic */ boolean access$2100() {
        return canShowTokenDialog();
    }

    private void delayRemoveClipChangeListener() {
        UiThreadUtils.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.15
            @Override // java.lang.Runnable
            public void run() {
                WordCommandManager.this.unRegisterClipChangedListener();
            }
        }, 5000L);
    }

    public static WordCommandManager getInstance() {
        if (sInstance == null) {
            synchronized (WrappedClipboardManager.class) {
                if (sInstance == null) {
                    sInstance = new WordCommandManager();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onComplete() {
        ICommandListener iCommandListener = this.mIBaiduListener;
        if (iCommandListener != null) {
            iCommandListener.onComplete();
            this.mIBaiduListener = null;
        }
    }

    private void onDialogShow() {
        ICommandListener iCommandListener = this.mIBaiduListener;
        if (iCommandListener != null) {
            iCommandListener.onDialogShow();
        }
    }

    public static void recordBehavior() {
        IBehaviorApi iBehaviorApi = (IBehaviorApi) ServiceManager.getService(IBehaviorApi.SERVICE_REFERENCE);
        if (iBehaviorApi != null) {
            iBehaviorApi.addBehavior(0, "clp", "", "basic");
        }
        if (AppConfig.isDebug()) {
            Log.d("WordCommandManager", "record clp behavior by wordcommand");
        }
    }

    public static void release() {
        sIsOnInitialUIReady = false;
        mOneselfShareString = null;
        sInstance = null;
    }

    public void getWordCommandConfigFromServer() {
        WordCommandRequest.getWordCommandConfigFromServer();
    }

    public String getWordCommandRegex() {
        String string = DefaultSharedPrefsWrapper.getInstance().getString(TOKEN_REGEX_DATA_SP_KEY, "");
        if (!TextUtils.isEmpty(string)) {
            return base64Decode(string);
        }
        return string;
    }

    public String getWordCommandRegexZH() {
        String string = DefaultSharedPrefsWrapper.getInstance().getString(TOKEN_REGEX_ZH_DATA_SP_KEY, "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return new String(Base64.decode(string, 0));
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return DEFAULT_DECODE_REGEX_ZH;
                }
                return DEFAULT_DECODE_REGEX_ZH;
            }
        }
        return DEFAULT_DECODE_REGEX_ZH;
    }

    public void handleClipboardWhenBackground() {
        unRegisterClipChangedListener();
        Activity topActivity = BdBoxActivityManager.getTopActivity();
        if (WordCommandRuntime.getWordCommandApp().isMainProcess() && !isTransparentActivity(topActivity)) {
            InvokeParamsManager.release();
        }
    }

    public boolean picWordCommandEnable() {
        try {
            return "1".equals(this.mSharedPrefsWrapper.getString(PIC_COMMAND_IS_OPEN_KEY, "0"));
        } catch (Exception unused) {
            return false;
        }
    }

    private void addDispatcherEvent(String str) {
        b40.c("external_dispatch_start", String.valueOf(this.mUBCDispatchStartTime));
        b40.c(CommandUBCHelper.COMMAND_UBC_TIME_START, String.valueOf(this.mUBCShareTokenStartTime));
        b40.c(CommandUBCHelper.COMMAND_UBC_CONTENT, this.mUBCClipboardString);
        b40.c("launch_scheme", str);
        b40.b("external_dispatch_end");
        b40.b(CommandUBCHelper.COMMAND_UBC_TIME_END);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String base64Decode(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Exception unused) {
            return DEFAULT_DECODE_REGEX;
        }
    }

    private boolean isTransparentActivity(Activity activity) {
        if (activity == null) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(CommandException commandException) {
        ICommandListener iCommandListener = this.mIBaiduListener;
        if (iCommandListener != null) {
            iCommandListener.onError(commandException);
            this.mIBaiduListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClipboardText(final String str) {
        UiThreadUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WordCommandManager.this.mWrappedClipboardManager != null) {
                        WordCommandManager.this.mWrappedClipboardManager.setText(str);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void setOnInitialUIReadyState(boolean z) {
        sIsOnInitialUIReady = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoPermission(final Context context) {
        new BoxAlertDialog.Builder(context).setTitle(com.baidu.tieba.R.string.wordcommand_permission_title).setMessage(com.baidu.tieba.R.string.wordcommand_permission_message).setPositiveButton(com.baidu.tieba.R.string.wordcommand_goto_setting, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", AppConfig.AppInfo.getPackageName(), null));
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                context.startActivity(intent);
                dialogInterface.dismiss();
            }
        }).show();
    }

    public void saveInvokeSchemeToSp(String str) {
        InvokeParamsManager.saveInvokeSchemeToSp(str);
    }

    public void setClearTokenEnable(boolean z) {
        this.mSharedPrefsWrapper.putBoolean(CLEAR_TOKEN_DATA_SP_KEY, z);
    }

    public void setPicWordCommandEnable(String str) {
        this.mSharedPrefsWrapper.putString(PIC_COMMAND_IS_OPEN_KEY, str);
    }

    public void setWordCommandRegex(String str) {
        DefaultSharedPrefsWrapper.getInstance().putString(TOKEN_REGEX_DATA_SP_KEY, str);
        if (DEBUG) {
            Log.d("WordCommandManager", "setWordCommandRegex: " + str);
        }
    }

    public void setWordCommandRegexZH(String str) {
        DefaultSharedPrefsWrapper.getInstance().putString(TOKEN_REGEX_ZH_DATA_SP_KEY, str);
        if (DEBUG) {
            Log.d("WordCommandManager", "setWordCommandRegexZH: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getWordCommandContent(final Context context, String str, final String str2) {
        WordCommandRequest.getWordCommandContent(str, str2, new IGetCommandContentListener() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.7
            @Override // com.baidu.searchbox.wordscommand.listener.IGetCommandContentListener
            public void getCommandContent(final CommandContent commandContent) {
                if (commandContent != null) {
                    if ("0".equals(str2)) {
                        if (WordCommandManager.DEBUG) {
                            Log.d("WordCommandManager", "getWordCommandContent clearClipboard commandType " + str2);
                        }
                        WordCommandManager.this.clearClipboard();
                    }
                    UiThreadUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            WordCommandManager.this.parseCommandContent(context, commandContent);
                        }
                    });
                    return;
                }
                b40.b(CommandUBCHelper.COMMAND_UBC_TIME_SERVER_ERROR);
                b40.c(CommandUBCHelper.COMMAND_UBC_ERROR_TYPE, CommandUBCHelper.COMMAND_UBC_ERROR_TYPE_SERVER);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImageToGallery(String str, final CommandToken commandToken) {
        if (!TextUtils.isEmpty(str)) {
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build(), AppRuntime.getAppContext()).subscribe(new BaseBitmapDataSubscriber() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.3
                @Override // com.facebook.datasource.BaseDataSubscriber
                public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                    CommandUBCHelper.ubcStatistics(CommandUBCHelper.PICTURE_COMMAND, "save", WordCommandManager.sShareCommandActivityId, "failed", null);
                    WordCommandManager wordCommandManager = WordCommandManager.this;
                    wordCommandManager.onError(new CommandException("fresco get bitmap is error  error:" + dataSource.getFailureCause()));
                }

                /* JADX WARN: Removed duplicated region for block: B:30:0x00e6  */
                @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onNewResultImpl(Bitmap bitmap) {
                    FileOutputStream fileOutputStream;
                    JSONObject jSONObject;
                    FileOutputStream fileOutputStream2 = null;
                    if (bitmap != null) {
                        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + WordCommandManager.DCIM);
                        if (!file.exists() && !file.mkdir()) {
                            return;
                        }
                        File file2 = new File(file, System.currentTimeMillis() + ".jpg");
                        try {
                            ParcelFileDescriptor openFileDescriptor = AppRuntime.getAppContext().getContentResolver().openFileDescriptor(Uri.fromFile(file2), "rw");
                            if (openFileDescriptor != null) {
                                fileOutputStream = new FileOutputStream(openFileDescriptor.getFileDescriptor());
                                try {
                                    try {
                                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                                        fileOutputStream.flush();
                                    } catch (Exception e) {
                                        e = e;
                                        if (AppConfig.isDebug()) {
                                            e.printStackTrace();
                                        }
                                        CommandUBCHelper.ubcStatistics(CommandUBCHelper.PICTURE_COMMAND, "save", WordCommandManager.sShareCommandActivityId, "failed", null);
                                        WordCommandManager.this.onError(new CommandException("save bitmap is error error :" + e));
                                        Closeables.closeSafely(fileOutputStream);
                                        AppRuntime.getAppContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file2)));
                                        String unused = WordCommandManager.mOneselfSharePictureCommand = file2.getAbsolutePath();
                                        CommandUBCHelper.ubcStatistics(CommandUBCHelper.PICTURE_COMMAND, "save", WordCommandManager.sShareCommandActivityId, CommandUBCHelper.COMMAND_UBC_VALUE_SUCCESS, null);
                                        String unused2 = WordCommandManager.mOneselfShareString = commandToken.content;
                                        WordCommandManager.this.setClipboardText(WordCommandManager.mOneselfShareString);
                                        jSONObject = commandToken.logparam;
                                        if (jSONObject != null) {
                                        }
                                        CommandUBCHelper.ubcStatistics(CommandUBCHelper.PICTURE_COMMAND, CommandUBCHelper.COMMAND_UBC_TYPE_COPY, WordCommandManager.sShareCommandActivityId, CommandUBCHelper.COMMAND_UBC_VALUE_SUCCESS, null);
                                        WordCommandManager.this.onComplete();
                                        return;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream2 = fileOutputStream;
                                    Closeables.closeSafely(fileOutputStream2);
                                    throw th;
                                }
                            } else {
                                fileOutputStream = null;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            Closeables.closeSafely(fileOutputStream2);
                            throw th;
                        }
                        Closeables.closeSafely(fileOutputStream);
                        AppRuntime.getAppContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file2)));
                        String unused3 = WordCommandManager.mOneselfSharePictureCommand = file2.getAbsolutePath();
                        CommandUBCHelper.ubcStatistics(CommandUBCHelper.PICTURE_COMMAND, "save", WordCommandManager.sShareCommandActivityId, CommandUBCHelper.COMMAND_UBC_VALUE_SUCCESS, null);
                        String unused22 = WordCommandManager.mOneselfShareString = commandToken.content;
                        WordCommandManager.this.setClipboardText(WordCommandManager.mOneselfShareString);
                        jSONObject = commandToken.logparam;
                        if (jSONObject != null) {
                            WordCommandManager.sShareCommandActivityId = jSONObject.optString("page");
                        }
                        CommandUBCHelper.ubcStatistics(CommandUBCHelper.PICTURE_COMMAND, CommandUBCHelper.COMMAND_UBC_TYPE_COPY, WordCommandManager.sShareCommandActivityId, CommandUBCHelper.COMMAND_UBC_VALUE_SUCCESS, null);
                        WordCommandManager.this.onComplete();
                        return;
                    }
                    CommandUBCHelper.ubcStatistics(CommandUBCHelper.PICTURE_COMMAND, "save", WordCommandManager.sShareCommandActivityId, "failed", null);
                    WordCommandManager.this.onError(new CommandException("save bitmap is null"));
                }
            }, UiThreadImmediateExecutorService.getInstance());
        }
    }

    public static boolean canShowTokenDialog() {
        Activity topActivity;
        if (!sIsOnInitialUIReady || (topActivity = BdBoxActivityManager.getTopActivity()) == null || topActivity.getClass().getSimpleName().equals(CommandUtil.LOCKSCREEN_ACTIVITY_CLASS) || topActivity.getClass().getSimpleName().equals(CommandUtil.LOCKSCREEN_DISMISS_ACTIVITY_CLASS) || CommandUtil.isLockScreenSettingsActivity(topActivity) || topActivity.getResources().getConfiguration().orientation == 2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doFinalProcessClipContent() {
        WrappedClipboardManager wrappedClipboardManager = this.mWrappedClipboardManager;
        if (wrappedClipboardManager == null) {
            handleLaunchDrag(null);
        } else if (!wrappedClipboardManager.hasText()) {
            if (DEBUG) {
                Log.d("WordCommandManager", "剪切板无数据");
            }
            registerClipChangedListener();
            delayRemoveClipChangeListener();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.10
                @Override // java.lang.Runnable
                public void run() {
                    WordCommandManager.this.handleLaunchDrag(null);
                    WordCommandManager.this.handlePictureCommand(AppRuntime.getAppContext());
                }
            }, "word_command_handleClipboardDataAsync", 2);
        } else {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.11
                @Override // java.lang.Runnable
                public void run() {
                    CharSequence text = WordCommandManager.this.mWrappedClipboardManager.getText();
                    CommandUBCHelper.ubcEvent(CommandUBCHelper.WORD_COMMAND_PARSE_DIALOG, "count");
                    WordCommandManager.this.handleLaunchDrag(text);
                    WordCommandManager.this.handleClipboardDataAsync(AppRuntime.getAppContext(), text);
                }
            }, "word_command_handleClipboardDataAsync", 2);
        }
    }

    private void registerClipChangedListener() {
        if (DEBUG) {
            Log.d("WordCommandManager", "registerClipChangedListener: ");
        }
        if (this.mClipboardManager == null) {
            this.mClipboardManager = (ClipboardManager) AppRuntime.getAppContext().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
        }
        if (this.mClipChangedListener == null && this.mClipboardManager != null) {
            ClipboardManager.OnPrimaryClipChangedListener onPrimaryClipChangedListener = new ClipboardManager.OnPrimaryClipChangedListener() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.14
                @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
                public void onPrimaryClipChanged() {
                    if (WordCommandManager.this.mWrappedClipboardManager == null) {
                        WordCommandManager.recordBehavior();
                    } else if (!WordCommandManager.this.mWrappedClipboardManager.hasText()) {
                        return;
                    } else {
                        CharSequence text = WordCommandManager.this.mWrappedClipboardManager.getText();
                        if (text == null) {
                            WordCommandManager.recordBehavior();
                            return;
                        }
                        final String charSequence = text.toString();
                        if (TextUtils.isEmpty(charSequence)) {
                            WordCommandManager.recordBehavior();
                            if (WordCommandManager.DEBUG) {
                                Log.d("WordCommandManager", "ClipChangedListener has no data,fail to word");
                                return;
                            }
                            return;
                        }
                        CommandUBCHelper.ubcEvent(CommandUBCHelper.WORD_COMMAND_PARSE_DIALOG, "count");
                        if (WordCommandManager.DEBUG) {
                            Log.d("WordCommandManager", "registerClipChangedListener clipboardDataStr: " + charSequence);
                        }
                        if (!TextUtils.isEmpty(charSequence) && WordCommandManager.access$2100()) {
                            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.14.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (WordCommandManager.DEBUG) {
                                        Log.d("WordCommandManager", "ClipChangedListener has data, continue run");
                                    }
                                    WordCommandManager.this.handleClipboardDataAsync(AppRuntime.getAppContext(), charSequence);
                                }
                            }, "word_command_handleClipboardDataAsync", 2);
                        }
                    }
                    WordCommandManager.this.unRegisterClipChangedListener();
                }
            };
            this.mClipChangedListener = onPrimaryClipChangedListener;
            try {
                this.mClipboardManager.addPrimaryClipChangedListener(onPrimaryClipChangedListener);
            } catch (Exception e) {
                if (AppConfig.isDebug()) {
                    e.printStackTrace();
                }
                this.mClipChangedListener = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegisterClipChangedListener() {
        ClipboardManager clipboardManager;
        boolean z;
        if (DEBUG) {
            StringBuilder sb = new StringBuilder();
            sb.append("unRegisterClipChangedListener: ");
            if (this.mClipChangedListener == null) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            Log.d("WordCommandManager", sb.toString());
        }
        if (this.mClipboardManager == null) {
            this.mClipboardManager = (ClipboardManager) AppRuntime.getAppContext().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
        }
        ClipboardManager.OnPrimaryClipChangedListener onPrimaryClipChangedListener = this.mClipChangedListener;
        if (onPrimaryClipChangedListener != null && (clipboardManager = this.mClipboardManager) != null) {
            clipboardManager.removePrimaryClipChangedListener(onPrimaryClipChangedListener);
            this.mClipChangedListener = null;
        }
    }

    public void handleClipboardData() {
        this.mUBCShareTokenStartTime = System.currentTimeMillis();
        if (!canShowTokenDialog()) {
            if (sIsOnInitialUIReady) {
                CharSequence charSequence = null;
                WrappedClipboardManager wrappedClipboardManager = this.mWrappedClipboardManager;
                if (wrappedClipboardManager != null && wrappedClipboardManager.hasText()) {
                    charSequence = this.mWrappedClipboardManager.getText();
                    recordBehavior();
                }
                handleLaunchDrag(charSequence);
                return;
            }
            return;
        }
        UiThreadUtils.getMainHandler().post(new Runnable() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.8
            @Override // java.lang.Runnable
            public void run() {
                if (Build.VERSION.SDK_INT >= 29) {
                    if (WordCommandManager.DEBUG) {
                        Log.d("WordCommandManager", "Android 10+");
                    }
                    WordCommandManager.this.selectActivityProcess(new WordCommandProcessCallback() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.8.1
                        @Override // com.baidu.searchbox.wordscommand.listener.WordCommandProcessCallback
                        public void onResult(Activity activity) {
                            if (activity == null) {
                                return;
                            }
                            WordCommandManager.this.doProcessAndroidQ();
                        }
                    });
                    return;
                }
                if (WordCommandManager.DEBUG) {
                    Log.d("WordCommandManager", "Android 10-");
                }
                WordCommandManager.this.doFinalProcessClipContent();
            }
        });
    }

    private boolean checkClipboardValid(CharSequence charSequence) {
        boolean z = false;
        if (charSequence != null && !TextUtils.isEmpty(charSequence)) {
            if (TextUtils.equals(mOneselfShareString, charSequence)) {
                clearClipboard();
                mOneselfShareString = null;
                if (DEBUG) {
                    Log.d("WordCommandManager", "自己分享的口令");
                }
                return false;
            }
            if (DEBUG) {
                Log.d("WordCommandManager", "WordCommandManagerhandleClipboardData() clipboardData.toString(): " + ((Object) charSequence));
            }
            if (isMatchRegexZH(charSequence)) {
                return true;
            }
            String wordCommandRegex = getWordCommandRegex();
            if (TextUtils.isEmpty(wordCommandRegex)) {
                wordCommandRegex = base64Decode(WORD_COMMAND_PRESET_REGEX);
            }
            if (DEBUG) {
                Log.d("WordCommandManager", "正则表达式是：" + wordCommandRegex);
            }
            try {
                z = Pattern.compile(wordCommandRegex).matcher(charSequence).find();
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (DEBUG) {
                Log.d("WordCommandManager", "是否符合匹配规则：" + z);
            }
            return z;
        }
        if (DEBUG) {
            Log.d("WordCommandManager", "剪切板内容为空");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClipboard() {
        boolean z = this.mSharedPrefsWrapper.getBoolean(CLEAR_TOKEN_DATA_SP_KEY, true);
        if (DEBUG) {
            Log.d("WordCommandManager", "clear_token_switch: " + z);
        }
        if (z) {
            setClipboardText(null);
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    if (this.mClipboardManager == null) {
                        this.mClipboardManager = (ClipboardManager) AppRuntime.getAppContext().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
                    }
                    this.mClipboardManager.clearPrimaryClip();
                } catch (Exception e) {
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private String getRecentImagePath() {
        String str = "";
        if (!DangerousPermissionUtils.isPermissionGroupGranted(AppRuntime.getAppContext(), WORD_COMMAND_PERMISSIONS)) {
            return "";
        }
        try {
            Cursor query = AppRuntime.getAppContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, "mime_type IN ( ? , ?) and date_modified >=? ", new String[]{"image/jpeg", IMAGE_PNG, String.valueOf((int) ((System.currentTimeMillis() / 1000) - TimeUnit.MINUTES.toSeconds(5L)))}, "date_modified DESC");
            if (query == null || !query.moveToNext()) {
                return "";
            }
            str = query.getString(query.getColumnIndex("_data"));
            query.close();
            return str;
        } catch (Exception unused) {
            return str;
        }
    }

    public boolean isHaveWordCommand() {
        try {
            if (AppConfig.isDebug()) {
                Log.d("WordCommandManager", "Begin isHaveWordCommand");
            }
            if (!WarmTipsManager.hasConfirmDialog()) {
                return false;
            }
            WrappedClipboardManager newInstance = WrappedClipboardManager.newInstance(AppRuntime.getAppContext());
            if (!newInstance.hasText()) {
                return false;
            }
            CharSequence text = newInstance.getText();
            recordBehavior();
            boolean checkClipboardValid = checkClipboardValid(text);
            if (AppConfig.isDebug()) {
                Log.d("WordCommandManager", "isHaveWordCommand: Text: " + ((Object) text) + ", isClipboardValid: " + checkClipboardValid);
            }
            return checkClipboardValid;
        } catch (Exception e) {
            if (AppConfig.isDebug()) {
                e.printStackTrace();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 29)
    public void doProcessAndroidQ() {
        Activity topActivity = BdBoxActivityManager.getTopActivity();
        if (topActivity == null) {
            if (DEBUG) {
                Log.d("WordCommandManager", "异常1，不做处理");
                return;
            }
            return;
        }
        String simpleName = topActivity.getClass().getSimpleName();
        if (DEBUG) {
            Log.d("WordCommandManager", "topActivity=" + simpleName);
        }
        final Runnable runnable = new Runnable() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.12
            @Override // java.lang.Runnable
            public void run() {
                if (WordCommandManager.DEBUG) {
                    Log.d("WordCommandManager", "doFinalProcessClipContent in runnable");
                }
                WordCommandManager.this.doFinalProcessClipContent();
            }
        };
        topActivity.registerActivityLifecycleCallbacks(new SimpleLifecycleCallback() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.13
            @Override // com.baidu.searchbox.wordscommand.util.SimpleLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NonNull Activity activity) {
                try {
                    activity.getWindow().getDecorView().removeCallbacks(runnable);
                    if (WordCommandManager.DEBUG) {
                        Log.d("WordCommandManager", "onActivityDestroyed removeCallbacks: " + activity.getClass().getSimpleName());
                    }
                } catch (Exception unused) {
                    if (WordCommandManager.DEBUG) {
                        Log.d("WordCommandManager", "异常2，不做处理");
                    }
                }
            }
        });
        try {
            if (!topActivity.isDestroyed()) {
                if (DEBUG) {
                    Log.d("WordCommandManager", "post post: " + topActivity.getClass().getSimpleName());
                }
                topActivity.getWindow().getDecorView().post(runnable);
            }
        } catch (Exception unused) {
            if (DEBUG) {
                Log.d("WordCommandManager", "异常3，不做处理");
            }
        }
    }

    public void setFirstInvokeFlag() {
        if (!IWordCommandApp.Impl.get().isNewInstall()) {
            if (DEBUG) {
                Log.d("WordCommandManager", "——> setFirstInvokeFlag: false (not new install)");
            }
        } else if (InvokeParamsSpUtil.getInstance().contains("is_first")) {
            if (DEBUG) {
                Log.d("WordCommandManager", "——> setFirstInvokeFlag: false (sp has key)");
            }
        } else {
            WrappedClipboardManager wrappedClipboardManager = this.mWrappedClipboardManager;
            if (wrappedClipboardManager != null && wrappedClipboardManager.hasText()) {
                CharSequence text = this.mWrappedClipboardManager.getText();
                recordBehavior();
                if (text == null) {
                    return;
                }
                if (checkClipboardValid(text.toString())) {
                    if (DEBUG) {
                        Log.d("WordCommandManager", "——> setFirstInvokeFlag: true (has valid token)");
                    }
                    InvokeParamsSpUtil.getInstance().putString("is_first", "1");
                    return;
                }
                if (DEBUG) {
                    Log.d("WordCommandManager", "——> setFirstInvokeFlag: false (has invalid token)");
                }
                InvokeParamsSpUtil.getInstance().putString("is_first", "0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handleClipboardDataAsync(Context context, CharSequence charSequence) {
        if (checkClipboardValid(charSequence)) {
            String charSequence2 = charSequence.toString();
            if (TextUtils.isEmpty(charSequence2)) {
                recordBehavior();
                return;
            }
            this.mUBCDispatchStartTime = System.currentTimeMillis();
            this.mUBCClipboardString = charSequence2;
            if (IWordCommandApp.Impl.get().canPreloadSwanApp(charSequence2)) {
                IWordCommandApp.Impl.get().handlePreloadSwanApp();
            }
            getWordCommandContent(context, charSequence2, "0");
        } else {
            recordBehavior();
            handlePictureCommand(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLaunchDrag(CharSequence charSequence) {
        if (!WarmTipsManager.hasConfirmDialog() || !sIsOnInitialUIReady) {
            return;
        }
        boolean z = false;
        if (this.mWrappedClipboardManager == null || TextUtils.isEmpty(charSequence) || !checkClipboardValid(charSequence)) {
            z = true;
        }
        if (z) {
            if (AppConfig.isDebug()) {
                Log.d("WordCommandManager", "handleLaunchDrag");
            }
            UiThreadUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.18
                @Override // java.lang.Runnable
                public void run() {
                    BdEventBus.Companion.getDefault().post(new WordCommandEvent(301));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handlePictureCommand(final Context context) {
        if (!picWordCommandEnable()) {
            if (AppConfig.isDebug()) {
                Log.d("WordCommandManager", "图片口令识别开关关闭");
            }
            return;
        }
        String recentImagePath = getRecentImagePath();
        this.mRecentImagePath = recentImagePath;
        if (TextUtils.isEmpty(recentImagePath)) {
            if (AppConfig.isDebug()) {
                Log.d("WordCommandManager", "获取5分钟内保存到相册的图片为空");
            }
        } else if (TextUtils.equals(this.mRecentImagePath, mOneselfSharePictureCommand)) {
            if (AppConfig.isDebug()) {
                Log.d("WordCommandManager", "相册第一张图片为自己分享的图片口令");
            }
        } else {
            if (TextUtils.equals(this.mRecentImagePath, InvokeParamsSpUtil.getInstance().getString(RECENT_SUCCESS_PIC_COMMAND_PATH, ""))) {
                if (AppConfig.isDebug()) {
                    Log.d("WordCommandManager", "最近解析过该图片，不能重复解析");
                }
                return;
            }
            IWordCommandApp.Impl.get().getPictureCommandContent(this.mRecentImagePath, new PictureCommandInvokeCallBack() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.16
                @Override // com.baidu.searchbox.wordscommand.listener.PictureCommandInvokeCallBack
                public void onResult(String str) {
                    if (AppConfig.isDebug()) {
                        Log.d("WordCommandManager", "图片口令识别结果：" + str);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            InvokeParamsSpUtil.getInstance().putString(WordCommandManager.RECENT_SUCCESS_PIC_COMMAND_PATH, WordCommandManager.this.mRecentImagePath);
                            String queryParameter = Uri.parse(new JSONObject(str).optString("text")).getQueryParameter(WordCommandManager.KEY_TK);
                            if (TextUtils.isEmpty(queryParameter)) {
                                CommandUBCHelper.ubcStatistics(CommandUBCHelper.PICTURE_COMMAND_PARSE, CommandUBCHelper.COMMAND_UBC_TYPE_CODESCAN, CommandUBCHelper.COMMAND_UBC_SOURCE_FAILED, "", null);
                                return;
                            }
                            boolean isMatchRegexZH = WordCommandManager.this.isMatchRegexZH(queryParameter);
                            if (!isMatchRegexZH) {
                                String wordCommandRegex = WordCommandManager.this.getWordCommandRegex();
                                if (TextUtils.isEmpty(wordCommandRegex)) {
                                    wordCommandRegex = WordCommandManager.this.base64Decode(WordCommandManager.WORD_COMMAND_PRESET_REGEX);
                                }
                                try {
                                    isMatchRegexZH = Pattern.compile(wordCommandRegex).matcher(queryParameter).find();
                                } catch (Exception e) {
                                    if (WordCommandManager.DEBUG) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            if (!isMatchRegexZH) {
                                CommandUBCHelper.ubcStatistics(CommandUBCHelper.PICTURE_COMMAND_PARSE, CommandUBCHelper.COMMAND_UBC_TYPE_CODESCAN, CommandUBCHelper.COMMAND_UBC_SOURCE_FAILED, "", null);
                                return;
                            }
                            if (IWordCommandApp.Impl.get().canPreloadSwanApp(queryParameter)) {
                                IWordCommandApp.Impl.get().handlePreloadSwanApp();
                            }
                            CommandUBCHelper.ubcStatistics(CommandUBCHelper.PICTURE_COMMAND_PARSE, CommandUBCHelper.COMMAND_UBC_TYPE_CODESCAN, CommandUBCHelper.COMMAND_UBC_SOURCE_SUCCESS, "", null);
                            WordCommandManager.this.getWordCommandContent(context, queryParameter, "1");
                            return;
                        } catch (Exception e2) {
                            if (AppConfig.isDebug()) {
                                e2.printStackTrace();
                            }
                            CommandUBCHelper.ubcStatistics(CommandUBCHelper.PICTURE_COMMAND_PARSE, CommandUBCHelper.COMMAND_UBC_TYPE_CODESCAN, CommandUBCHelper.COMMAND_UBC_SOURCE_FAILED, "", null);
                            return;
                        }
                    }
                    CommandUBCHelper.ubcStatistics(CommandUBCHelper.PICTURE_COMMAND_PARSE, CommandUBCHelper.COMMAND_UBC_TYPE_CODESCAN, CommandUBCHelper.COMMAND_UBC_SOURCE_FAILED, "", null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMatchRegexZH(CharSequence charSequence) {
        String wordCommandRegexZH = getWordCommandRegexZH();
        if (TextUtils.isEmpty(wordCommandRegexZH)) {
            wordCommandRegexZH = DEFAULT_DECODE_REGEX_ZH;
        }
        boolean z = false;
        try {
            z = Pattern.compile(wordCommandRegexZH).matcher(charSequence).find();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.d("WordCommandManager", "中文正则匹配规则：" + wordCommandRegexZH);
            Log.d("WordCommandManager", "是否符合中文正则匹配规则：" + z);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 29)
    public void selectActivityProcess(final WordCommandProcessCallback wordCommandProcessCallback) {
        if (wordCommandProcessCallback == null) {
            return;
        }
        Activity topActivity = BdBoxActivityManager.getTopActivity();
        if (topActivity == null) {
            if (AppConfig.isDebug()) {
                Log.d("WordCommandManager", "Top Activity Is Null");
            }
            wordCommandProcessCallback.onResult(null);
        } else if (isTransparentActivity(topActivity)) {
            if (AppConfig.isDebug()) {
                Log.d("WordCommandManager", "Top Activity Is " + topActivity.getClass().getSimpleName());
            }
            BdBoxActivityManager.registerLifeCycle(new SimpleActivityLifeCycle() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.9
                @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
                public void onActivityDestroyed(Activity activity) {
                    if (AppConfig.isDebug()) {
                        Log.d("WordCommandManager", activity.getClass().getSimpleName() + " destroyed");
                    }
                    BdBoxActivityManager.unregisterLifeCycle(this);
                    WordCommandManager.this.selectActivityProcess(wordCommandProcessCallback);
                }
            });
        } else {
            wordCommandProcessCallback.onResult(topActivity);
        }
    }

    private boolean shouldDismissCommandDialog(CommandContent commandContent) {
        String str;
        if (DEBUG) {
            Log.d("WordCommandManager", "——> shouldDismissCommandDialog: " + commandContent.scheme);
        }
        if (commandContent == null) {
            return true;
        }
        String invokeSchemeFromSp = InvokeParamsManager.getInvokeSchemeFromSp();
        if (TextUtils.isEmpty(invokeSchemeFromSp)) {
            return false;
        }
        boolean equals = TextUtils.equals(invokeSchemeFromSp, commandContent.scheme);
        InvokeParamsManager.release();
        String str2 = sDecodeCommandActivityId;
        if (equals) {
            str = "1";
        } else {
            str = "0";
        }
        CommandUBCHelper.ubcStatisticsWithValue(CommandUBCHelper.WORD_COMMAND_PARSE_DIALOG, "repeat", CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT, str2, str);
        return equals;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseCommandContent(Context context, CommandContent commandContent) {
        if (context != null && commandContent != null) {
            if (commandContent.isRepeat) {
                CommandUBCHelper.ubcStatisticsWithValue(CommandUBCHelper.WORD_COMMAND_PARSE_DIALOG, "repeat", CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_SERVER, sDecodeCommandActivityId, null);
                b40.c(CommandUBCHelper.COMMAND_UBC_ERROR_TYPE, CommandUBCHelper.COMMAND_UBC_ERROR_TYPE_REPEAT);
                if (AppConfig.isDebug()) {
                    Log.d("WordCommandManager", "重复了，度口令不跳转了");
                }
            } else if (shouldDismissCommandDialog(commandContent)) {
                b40.b("external_dispatch_end");
                b40.c(CommandUBCHelper.COMMAND_UBC_ERROR_TYPE, CommandUBCHelper.COMMAND_UBC_ERROR_TYPE_REPEAT);
            } else {
                c40.d(CommandUBCHelper.COMMAND_UBC_SHARE_TOKEN);
                if (!commandContent.mShowable) {
                    IWordCommandApp.Impl.get().schemeInvoke(commandContent.scheme);
                } else {
                    IWordCommandApp.Impl.get().doOnShowParseCommandDialogWithPopupExclusion(context, commandContent);
                }
                addDispatcherEvent(commandContent.scheme);
                if (AppConfig.isDebug()) {
                    Log.d("WordCommandManager", "度口令真实跳转了");
                }
                JSONObject jSONObject = commandContent.logparam;
                if (jSONObject != null) {
                    sDecodeCommandActivityId = jSONObject.optString("page");
                    sDecodeCommandUbcLogExt = jSONObject.optJSONObject("ext");
                }
                CommandUBCHelper.executeWordCommandUbcStatistics(CommandUBCHelper.WORD_COMMAND_PARSE_DIALOG, "show", "", sDecodeCommandActivityId, sDecodeCommandUbcLogExt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PrivateResource"})
    public void showBuildCommandDialog(Context context, CommandToken commandToken) {
        if (commandToken != null && !TextUtils.isEmpty(this.mContentString) && !TextUtils.isEmpty(commandToken.content) && context != null) {
            mOneselfShareString = commandToken.content;
            View inflate = LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.build_box_word_command_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.R.id.word_command_content_message);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.R.id.word_command_content_title);
            textView.setText(mOneselfShareString);
            textView2.setText(this.mTitleString);
            textView.setTextColor(context.getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0601cd));
            textView.setBackground(ResourcesCompat.getDrawable(context.getResources(), com.baidu.tieba.R.drawable.word_command_message_textview_bg, null));
            textView2.setBackgroundColor(context.getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f060194));
            textView2.setTextColor(context.getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f060193));
            new BdAlertDialog.Builder(context).setView(inflate).setButton(new BdAlertDialog.ButtonItem(context.getText(com.baidu.tieba.R.string.word_command_build_negative_bt), new BuildDialogCancelListener())).setButton(new BdAlertDialog.ButtonItem(context.getText(com.baidu.tieba.R.string.word_command_build_positive_bt), (int) com.baidu.tieba.R.color.obfuscated_res_0x7f0601ee, new BuildDialogConfirmListener(mOneselfShareString))).setonKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.1
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i == 4) {
                        CommandUBCHelper.executeWordCommandUbcStatistics(CommandUBCHelper.WORD_COMMAND_BUILD_DIALOG, "click", "cancel", WordCommandManager.sShareCommandActivityId, null);
                        return false;
                    }
                    return false;
                }
            }).create().show();
            onDialogShow();
            JSONObject jSONObject = commandToken.logparam;
            if (jSONObject != null) {
                sShareCommandActivityId = jSONObject.optString("page");
            }
            CommandUBCHelper.executeWordCommandUbcStatistics(CommandUBCHelper.WORD_COMMAND_BUILD_DIALOG, "show", "", sShareCommandActivityId, null);
        }
    }

    @SuppressLint({"PrivateResource"})
    public void doOnShowParseCommandDialog(Context context, CommandContent commandContent, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnShowListener onShowListener) {
        View inflate = LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.parse_box_word_command_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.R.id.word_command_content_message);
        TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.R.id.word_command_content_title);
        textView.setTextColor(context.getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0601c2));
        textView2.setBackgroundColor(context.getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f060194));
        ((BdBaseImageView) inflate.findViewById(com.baidu.tieba.R.id.word_command_banner_circular_arc)).setBackground(ResourcesCompat.getDrawable(context.getResources(), com.baidu.tieba.R.drawable.word_command_banner_circular_arc, null));
        textView2.setTextColor(context.getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f060193));
        textView.setText(commandContent.tips);
        textView2.setText(commandContent.title);
        ((SimpleDraweeView) inflate.findViewById(com.baidu.tieba.R.id.word_command_content_img)).setImageURI(commandContent.imgUrl);
        BdDialog.Builder view2 = new BdDialog.Builder().setView(inflate);
        if (TextUtils.isEmpty(commandContent.btnCancle)) {
            view2.setButton(new BdDialog.BottomItem(context.getText(com.baidu.tieba.R.string.word_command_parse_negative_bt), new ParseDialogCancelListener()));
        } else {
            view2.setButton(new BdDialog.BottomItem(commandContent.btnCancle, new ParseDialogCancelListener()));
        }
        if (TextUtils.isEmpty(commandContent.btnSure)) {
            view2.setButton(new BdDialog.BottomItem(context.getString(com.baidu.tieba.R.string.word_command_parse_positive_bt), (int) com.baidu.tieba.R.color.obfuscated_res_0x7f0601ee, new ParseDialogConfirmListener(commandContent.scheme)));
        } else {
            view2.setButton(new BdDialog.BottomItem(commandContent.btnSure, (int) com.baidu.tieba.R.color.obfuscated_res_0x7f0601ee, new ParseDialogConfirmListener(commandContent.scheme)));
        }
        view2.setOnDismissListener(onDismissListener);
        view2.setonShowListener(onShowListener);
        view2.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    CommandUBCHelper.executeWordCommandUbcStatistics(CommandUBCHelper.WORD_COMMAND_PARSE_DIALOG, "click", "cancel", WordCommandManager.sDecodeCommandActivityId, WordCommandManager.sDecodeCommandUbcLogExt);
                    return false;
                }
                return false;
            }
        });
        view2.show();
    }

    public void shareWithCommand(final Context context, String str, final boolean z, ICommandListener iCommandListener) {
        if (iCommandListener == null) {
            return;
        }
        unRegisterClipChangedListener();
        this.mIBaiduListener = iCommandListener;
        if (context != null && !TextUtils.isEmpty(str)) {
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (jSONObject == null) {
                onError(new CommandException("json parse error"));
                return;
            }
            String optString = jSONObject.optString("key");
            this.mTitleString = jSONObject.optString("title");
            this.mContentString = jSONObject.optString("content");
            final String optString2 = jSONObject.optString("type", "0");
            final String optString3 = jSONObject.optString(KEY_IMAGE_SAVE);
            if (TextUtils.isEmpty(optString)) {
                onError(new CommandException("key is empty"));
                return;
            } else if ("1".equals(optString2) && z && TextUtils.isEmpty(optString3)) {
                onError(new CommandException("img is empty"));
                return;
            } else if (z && !DangerousPermissionUtils.isPermissionGroupGranted(context, WORD_COMMAND_PERMISSIONS)) {
                DangerousPermissionUtils.requestPermissions("word_command", context, WORD_COMMAND_PERMISSIONS, 0, new DangerousPermissionManager.RequestSystemPermissionCallBack() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.5
                    @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestSystemPermissionCallBack
                    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                        if (iArr != null && iArr.length != 0) {
                            if (iArr[0] != 0 && !ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                                WordCommandManager.this.showNoPermission(context);
                            }
                            if (Build.VERSION.SDK_INT >= 23) {
                                Context context2 = context;
                                if (context2 instanceof Activity) {
                                    ((Activity) context2).onRequestPermissionsResult(i, strArr, iArr);
                                }
                            }
                            WordCommandManager.this.onError(new CommandException("WRITE_EXTERNAL_STORAGE permission denied"));
                        }
                    }
                });
                return;
            } else {
                WordCommandRequest.getWordCommandToken(optString, this.mContentString, new IGetCommonTokenListener() { // from class: com.baidu.searchbox.wordscommand.WordCommandManager.6
                    @Override // com.baidu.searchbox.wordscommand.listener.IGetCommonTokenListener
                    public void onFail(Exception exc) {
                        WordCommandManager wordCommandManager = WordCommandManager.this;
                        wordCommandManager.onError(new CommandException("request token failed, exception: " + exc.toString()));
                    }

                    @Override // com.baidu.searchbox.wordscommand.listener.IGetCommonTokenListener
                    public void onSuccess(CommandToken commandToken) {
                        if (commandToken != null) {
                            if ("0".equals(optString2)) {
                                WordCommandManager.this.showBuildCommandDialog(context, commandToken);
                                return;
                            } else if (!z) {
                                String unused = WordCommandManager.mOneselfShareString = commandToken.content;
                                WordCommandManager.this.setClipboardText(WordCommandManager.mOneselfShareString);
                                CommandUBCHelper.ubcStatistics(CommandUBCHelper.PICTURE_COMMAND, CommandUBCHelper.COMMAND_UBC_TYPE_COPY, WordCommandManager.sShareCommandActivityId, CommandUBCHelper.COMMAND_UBC_VALUE_SUCCESS, null);
                                WordCommandManager.this.onComplete();
                                return;
                            } else {
                                WordCommandManager.this.saveImageToGallery(optString3, commandToken);
                                return;
                            }
                        }
                        WordCommandManager.this.onError(new CommandException("commandToken is empty"));
                    }
                });
                return;
            }
        }
        onError(new CommandException("activity params is empty"));
    }
}
