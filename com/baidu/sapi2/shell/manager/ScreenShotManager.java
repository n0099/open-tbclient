package com.baidu.sapi2.shell.manager;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.sapi2.shell.listener.IScreenShotListener;
import com.baidu.sapi2.utils.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ScreenShotManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String[] KEYWORDS;
    public static final String[] MEDIA_PROJECTIONS;
    public static final String SCREEN_SHOT_OBSERVER = "screen_shot_observer";
    public transient /* synthetic */ FieldHolder $fh;
    public ContentResolver mContentResolver;
    public MediaContentObserver mExternalObserver;
    public Handler mHandler;
    public HandlerThread mHandlerThread;
    public MediaContentObserver mInternalObserver;
    public IScreenShotListener mScreenShotListener;

    /* loaded from: classes4.dex */
    public class MediaContentObserver extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Uri mContentUri;
        public final /* synthetic */ ScreenShotManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaContentObserver(ScreenShotManager screenShotManager, Uri uri, Handler handler) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {screenShotManager, uri, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = screenShotManager;
            this.mContentUri = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.onChange(z);
                this.this$0.handleMediaContentChange(this.mContentUri);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1018477735, "Lcom/baidu/sapi2/shell/manager/ScreenShotManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1018477735, "Lcom/baidu/sapi2/shell/manager/ScreenShotManager;");
                return;
            }
        }
        KEYWORDS = new String[]{StatisticConstants.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
        MEDIA_PROJECTIONS = new String[]{"_data", "datetaken"};
    }

    public ScreenShotManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
        if (r0.isClosed() != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMediaContentChange(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, uri) == null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = this.mContentResolver.query(uri, MEDIA_PROJECTIONS, null, null, "date_added desc limit 1");
                } catch (Exception e2) {
                    Log.e(e2);
                    if (cursor == null || cursor.isClosed()) {
                        return;
                    }
                }
                if (cursor != null && cursor.moveToFirst()) {
                    handleMediaRowData(cursor.getString(cursor.getColumnIndex("_data")), cursor.getLong(cursor.getColumnIndex("datetaken")));
                    if (cursor == null || cursor.isClosed()) {
                        return;
                    }
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    private void handleMediaRowData(String str, long j) {
        IScreenShotListener iScreenShotListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, this, str, j) == null) {
            long j2 = 0;
            while (!isScreenShot(str) && j2 <= 500) {
                j2 += 100;
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e2) {
                    Log.e(e2);
                }
            }
            if (!isScreenShot(str) || (iScreenShotListener = this.mScreenShotListener) == null) {
                return;
            }
            iScreenShotListener.onScreenShot();
        }
    }

    private boolean isScreenShot(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            if (str == null) {
                return false;
            }
            String lowerCase = str.toLowerCase();
            for (String str2 : KEYWORDS) {
                if (lowerCase.contains(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void init(ContentResolver contentResolver, IScreenShotListener iScreenShotListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, contentResolver, iScreenShotListener) == null) {
            this.mContentResolver = contentResolver;
            this.mScreenShotListener = iScreenShotListener;
            HandlerThread handlerThread = new HandlerThread(SCREEN_SHOT_OBSERVER);
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper());
            this.mInternalObserver = new MediaContentObserver(this, MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.mHandler);
            this.mExternalObserver = new MediaContentObserver(this, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.mHandler);
        }
    }

    public void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mContentResolver.registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.mInternalObserver);
            this.mContentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.mExternalObserver);
        }
    }

    public void unRegister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mContentResolver.unregisterContentObserver(this.mInternalObserver);
            this.mContentResolver.unregisterContentObserver(this.mExternalObserver);
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.mHandler = null;
            }
            HandlerThread handlerThread = this.mHandlerThread;
            if (handlerThread != null) {
                handlerThread.quit();
            }
        }
    }
}
