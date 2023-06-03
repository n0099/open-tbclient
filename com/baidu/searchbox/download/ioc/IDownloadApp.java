package com.baidu.searchbox.download.ioc;

import android.app.Notification;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.download.model.DownloadInfo;
/* loaded from: classes3.dex */
public interface IDownloadApp {
    public static final IDownloadApp EMPTY = new IDownloadApp() { // from class: com.baidu.searchbox.download.ioc.IDownloadApp.1
        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public Intent buildDownloadActivityIntent(Context context) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public Intent buildDownloadInstallGuideIntent(Context context, String str, String str2, String str3) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public Intent buildDownloadIntent(Context context, Intent intent) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public Intent buildVideoContinueActivityIntent(Context context) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void cancelDownload(long j) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void checkUnfinishedTask() {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void delete(long... jArr) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void doAppExit(Context context) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public boolean doCheckPluginDownloadedJob(Context context, Uri uri, String str) {
            return false;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void doDownloadStartStatics(String str, String str2) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void doDownloadStartStatics(String str, String str2, String str3) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void doInsertDownloadUriNotNull(ContentValues contentValues, Uri uri, boolean z, int i) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void doNovelSendCompleteMsgJob(long j, String str, String str2, String str3, int i, String str4) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void doNovelSendDownloadMsg(long j, String str, String str2, String str3, String str4, long j2, String str5, int i) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void doRestartDownloadJob(long j) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void doSearchBoxDownloadControlAddJob(ContentValues contentValues) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void doSearchBoxDownloadControlDelete(Context context, long... jArr) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void doSearchBoxStateInfoRelease() {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void doSendCompleteMsgVideoBussiness(long j) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void doVideoDoDownloadBussiness(ContentValues contentValues, String str, String str2) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void doVideoEpisodeVidBussiness(ContentValues contentValues) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void doWebkitJob(Context context, boolean z) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void downloadedUBCSend(String str, String str2, String str3) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public String getBookFreeCode() {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public String getDownloadChannel() {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public String getDownloadedChannel() {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public Intent getDownloadedVideoActivityIntent(Context context) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public String getFrom() {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public String getHashedString(String str) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public int getNovelDownloadModeMultiRange() {
            return 0;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public int getNovelDownloadModeSingleRange() {
            return 0;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public String getNovelSegmentStatus() {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public int getNovelStatusDownloadEnd() {
            return 0;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public String getNovelStatusTimestamp() {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public String getOpenDownloadReceiverCanonicalName() {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public Cursor getSearchboxDownloadCursor(long j) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public String getStoryMimeType() {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public String getStoryRange() {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public String getStoryStartRange() {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public Uri getUri(String str) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public Class<?> getVideoContinueActivity() {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public String getVideoContinueActivityKeyDownloadInfo() {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public String getVideoContinueActivityKeyDownloadType() {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public String getVideoErrorMessage(Context context, DownloadInfo downloadInfo, Throwable th, int i) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public Uri getWebkitUri(Context context) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public boolean isComponentEnable(Context context, String str) {
            return false;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public boolean isRead(long j) {
            return false;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public String isStory(long j, String str, String str2) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void notifySearchBoxDownloadControlObservers() {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void pauseInstallToAllWithoutManual(Context context) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void postNewTipsSrcChangeMessage() {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void processUnRead(boolean z, Uri uri) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public Intent putNovelExtra(Intent intent) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public int queryTitleCount(String str) {
            return 0;
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void restoreBookTypeByGid(Long l) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void setNotificationChannelAndGroupId(Notification.Builder builder, String str) {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void startAutoBackup() {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void startVideoDownload() {
        }

        @Override // com.baidu.searchbox.download.ioc.IDownloadApp
        public void updateDownloadTitle(String str, String str2, long j) {
        }
    };
    public static final String LOG_TAG = "IDownloadApp";

    Intent buildDownloadActivityIntent(Context context);

    Intent buildDownloadInstallGuideIntent(Context context, String str, String str2, String str3);

    Intent buildDownloadIntent(Context context, Intent intent);

    Intent buildVideoContinueActivityIntent(Context context);

    void cancelDownload(long j);

    void checkUnfinishedTask();

    void delete(long... jArr);

    void doAppExit(Context context);

    boolean doCheckPluginDownloadedJob(Context context, Uri uri, String str);

    void doDownloadStartStatics(String str, String str2);

    void doDownloadStartStatics(String str, String str2, String str3);

    void doInsertDownloadUriNotNull(ContentValues contentValues, Uri uri, boolean z, int i);

    void doNovelSendCompleteMsgJob(long j, String str, String str2, String str3, int i, String str4);

    void doNovelSendDownloadMsg(long j, String str, String str2, String str3, String str4, long j2, String str5, int i);

    void doRestartDownloadJob(long j);

    void doSearchBoxDownloadControlAddJob(ContentValues contentValues);

    void doSearchBoxDownloadControlDelete(Context context, long... jArr);

    void doSearchBoxStateInfoRelease();

    void doSendCompleteMsgVideoBussiness(long j);

    void doVideoDoDownloadBussiness(ContentValues contentValues, String str, String str2);

    void doVideoEpisodeVidBussiness(ContentValues contentValues);

    void doWebkitJob(Context context, boolean z);

    void downloadedUBCSend(String str, String str2, String str3);

    String getBookFreeCode();

    String getDownloadChannel();

    String getDownloadedChannel();

    Intent getDownloadedVideoActivityIntent(Context context);

    String getFrom();

    String getHashedString(String str);

    int getNovelDownloadModeMultiRange();

    int getNovelDownloadModeSingleRange();

    String getNovelSegmentStatus();

    int getNovelStatusDownloadEnd();

    String getNovelStatusTimestamp();

    String getOpenDownloadReceiverCanonicalName();

    Cursor getSearchboxDownloadCursor(long j);

    String getStoryMimeType();

    String getStoryRange();

    String getStoryStartRange();

    Uri getUri(String str);

    Class<?> getVideoContinueActivity();

    String getVideoContinueActivityKeyDownloadInfo();

    String getVideoContinueActivityKeyDownloadType();

    String getVideoErrorMessage(Context context, DownloadInfo downloadInfo, Throwable th, int i);

    Uri getWebkitUri(Context context);

    boolean isComponentEnable(Context context, String str);

    boolean isRead(long j);

    String isStory(long j, String str, String str2);

    void notifySearchBoxDownloadControlObservers();

    void pauseInstallToAllWithoutManual(Context context);

    void postNewTipsSrcChangeMessage();

    void processUnRead(boolean z, Uri uri);

    Intent putNovelExtra(Intent intent);

    int queryTitleCount(String str);

    void restoreBookTypeByGid(Long l);

    void setNotificationChannelAndGroupId(Notification.Builder builder, String str);

    void startAutoBackup();

    void startVideoDownload();

    void updateDownloadTitle(String str, String str2, long j);

    /* loaded from: classes3.dex */
    public static final class Impl {
        public static IDownloadApp sIDownloadApp = DownloadRuntime.getDownloadApp();

        @NonNull
        public static IDownloadApp get() {
            if (sIDownloadApp == null) {
                Log.w(IDownloadApp.LOG_TAG, "Fetch IDownloadApp implementation failed, IDownloadApp.EMPTY applied");
                sIDownloadApp = IDownloadApp.EMPTY;
            }
            return sIDownloadApp;
        }
    }
}
