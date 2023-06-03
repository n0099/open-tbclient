package com.baidu.searchbox.download.model;

import android.text.TextUtils;
import com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.download.unified.DownloadInfoData;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CategoryInfoData implements Serializable {
    public static final int GUIDE_CLEAR_STATE_CANNOT_INSTALL = 2;
    public static final int GUIDE_CLEAR_STATE_INSTALL = 1;
    public static final int GUIDE_CLEAR_STATE_LONGNOT_DOWNLAOD = 3;
    public static final int GUIDE_CLEAR_STATE_UNINSTALL = 0;
    public static final long HAS_UNZIP_ID = -1;
    public static final int PROGRESS_COMPLETE = 100;
    public static final long serialVersionUID = -8065188059096533339L;
    public String businessId;
    public int guideClearState;
    public String mAppIcon;
    public String mBookDirectoryUrl;
    public int mBookType;
    public int mBusinessType;
    public String mCompleteTimeStr;
    public long mCompletionTime;
    public String mDownloadInfo;
    public String mDownloadPath;
    public DownloadingInfo mDownloadingInfo;
    public String mExtraInfo;
    public String mFileName;
    public String mFree;
    public long mGid;
    public long mId;
    public boolean mIsDeleted;
    public boolean mIsHighlight;
    public boolean mIsLocal;
    public boolean mIsNull;
    public boolean mIsSelected;
    public String mMimeType;
    public NetdiskUploadInfo mNetdiskUploadInfo;
    public boolean mOpenRead;
    public long mOpenTime;
    public long mSize;
    public String mSource;
    public String mStoryPosition;
    public float mStoryViewProgress;
    public String mSubTitle;
    public long mType;
    public boolean newFlag;
    public int progress;

    public CategoryInfoData() {
        this.newFlag = false;
        this.mStoryViewProgress = -1.0f;
        this.mStoryPosition = "";
        this.mCompleteTimeStr = null;
        this.mBookType = 1;
        this.mFree = IDownloadApp.Impl.get().getBookFreeCode();
        this.mNetdiskUploadInfo = new NetdiskUploadInfo();
        this.mIsNull = false;
        this.mIsLocal = false;
    }

    public String getCompleteTimeStr() {
        if (this.mCompleteTimeStr == null) {
            this.mCompleteTimeStr = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date(this.mCompletionTime));
        }
        return this.mCompleteTimeStr;
    }

    public long getGid() {
        return this.mGid;
    }

    public boolean isHasUnZipItem() {
        if (this.mId == -1) {
            return true;
        }
        return false;
    }

    public boolean isHighlight() {
        return this.mIsHighlight;
    }

    public boolean isNull() {
        return this.mIsNull;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    public CategoryInfoData(boolean z) {
        this.newFlag = false;
        this.mStoryViewProgress = -1.0f;
        this.mStoryPosition = "";
        this.mCompleteTimeStr = null;
        this.mBookType = 1;
        this.mFree = IDownloadApp.Impl.get().getBookFreeCode();
        this.mNetdiskUploadInfo = new NetdiskUploadInfo();
        this.mIsNull = z;
    }

    public void setGid(long j) {
        this.mGid = j;
    }

    public void setHighlight(boolean z) {
        this.mIsHighlight = z;
    }

    public void setSelected(boolean z) {
        this.mIsSelected = z;
    }

    public static CategoryInfoData transformFromDownloadInfoData(DownloadInfoData downloadInfoData) {
        CategoryInfoData categoryInfoData = new CategoryInfoData();
        categoryInfoData.mId = downloadInfoData.getId();
        categoryInfoData.mType = downloadInfoData.getCategory();
        categoryInfoData.mSize = downloadInfoData.getTotalSize();
        categoryInfoData.mMimeType = downloadInfoData.getMimeType();
        categoryInfoData.mFileName = downloadInfoData.getFileName();
        categoryInfoData.mDownloadPath = downloadInfoData.getFilePath();
        categoryInfoData.mCompletionTime = downloadInfoData.getTimeStampLastModification();
        categoryInfoData.mExtraInfo = downloadInfoData.getExtraInfo();
        DownloadingInfo downloadingInfo = new DownloadingInfo();
        categoryInfoData.mDownloadingInfo = downloadingInfo;
        downloadingInfo.mCurrentSize = downloadInfoData.getCurrentSize();
        categoryInfoData.mDownloadingInfo.mStatus = downloadInfoData.getStatus();
        categoryInfoData.mDownloadingInfo.mReason = downloadInfoData.getErrorReason();
        return categoryInfoData;
    }

    public void putExtra(String str, String str2) {
        JSONObject jSONObject;
        try {
            if (TextUtils.isEmpty(this.mExtraInfo)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(this.mExtraInfo);
            }
            jSONObject.put(str, str2);
        } catch (JSONException unused) {
        }
    }
}
