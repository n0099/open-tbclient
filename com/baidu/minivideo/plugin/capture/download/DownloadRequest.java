package com.baidu.minivideo.plugin.capture.download;

import android.text.TextUtils;
import com.baidu.minivideo.plugin.capture.download.utils.FileUtils;
import java.io.File;
/* loaded from: classes2.dex */
public class DownloadRequest {
    public CharSequence mDescription;
    public File mFolder;
    public CharSequence mName;
    public String mUri;

    /* loaded from: classes2.dex */
    public static class Builder {
        public CharSequence mDescription;
        public File mFolder;
        public CharSequence mName;
        public String mUri;

        public DownloadRequest build() {
            return new DownloadRequest(this.mUri, this.mFolder, this.mName, this.mDescription);
        }

        public Builder setDescription(CharSequence charSequence) {
            this.mDescription = charSequence;
            return this;
        }

        public Builder setFolder(File file) {
            this.mFolder = file;
            return this;
        }

        public Builder setName(CharSequence charSequence) {
            this.mName = charSequence;
            return this;
        }

        public Builder setUri(String str) {
            this.mUri = str;
            return this;
        }
    }

    public CharSequence getDescription() {
        return this.mDescription;
    }

    public File getFolder() {
        return this.mFolder;
    }

    public CharSequence getName() {
        if (TextUtils.isEmpty(this.mName)) {
            this.mName = FileUtils.getFileFullName(getUri());
        }
        return this.mName;
    }

    public String getUri() {
        return this.mUri;
    }

    public DownloadRequest() {
    }

    public DownloadRequest(String str, File file, CharSequence charSequence, CharSequence charSequence2) {
        this.mUri = str;
        this.mFolder = file;
        this.mName = charSequence;
        this.mDescription = charSequence2;
    }
}
