package com.baidu.cyberplayer.sdk.videodownload;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.Keep;
import java.util.HashMap;
@Keep
/* loaded from: classes3.dex */
public class DuMediaDownloadItem {
    public static final String TAG = "DuMediaDownloadItem";
    public String mExtra;
    public IDuMediaDownloadItemListener mListener;
    public long mOffset;
    public long mSize;
    public String mUrl;
    public HashMap<String, String> mHeaders = null;
    public HashMap<String, String> mOptions = null;

    /* loaded from: classes3.dex */
    public static class Builder {
        public String mUrl;
        public long mSize = 2147483647L;
        public long mOffset = 0;

        public DuMediaDownloadItem build() {
            return new DuMediaDownloadItem(this);
        }

        public Builder setOffset(long j) {
            this.mOffset = j;
            return this;
        }

        public Builder setSize(long j) {
            this.mSize = j;
            return this;
        }

        public Builder setUrl(String str) {
            this.mUrl = str;
            return this;
        }
    }

    public DuMediaDownloadItem(Builder builder) {
        this.mUrl = null;
        this.mSize = 2147483647L;
        this.mOffset = 0L;
        this.mUrl = builder.mUrl;
        this.mOffset = builder.mOffset;
        this.mSize = builder.mSize;
    }

    public void setCallBackListener(IDuMediaDownloadItemListener iDuMediaDownloadItemListener) {
        this.mListener = iDuMediaDownloadItemListener;
    }

    public void setExtra(String str) {
        this.mExtra = str;
    }

    public IDuMediaDownloadItemListener getCallBackListener() {
        return this.mListener;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public HashMap<String, String> getHeaders() {
        return this.mHeaders;
    }

    public long getOffset() {
        return this.mOffset;
    }

    public HashMap<String, String> getOptions() {
        return this.mOptions;
    }

    public long getSize() {
        return this.mSize;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setCustomHeader(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mHeaders == null) {
                this.mHeaders = new HashMap<>();
            }
            HashMap<String, String> hashMap = this.mHeaders;
            hashMap.put(str.substring(0, 1).toUpperCase() + str.substring(1), str2);
        }
    }

    public void setOption(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mOptions == null) {
                this.mOptions = new HashMap<>();
            }
            this.mOptions.put(str, str2);
        }
    }
}
