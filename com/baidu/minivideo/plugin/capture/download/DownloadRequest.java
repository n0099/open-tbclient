package com.baidu.minivideo.plugin.capture.download;

import android.text.TextUtils;
import com.baidu.minivideo.plugin.capture.download.utils.FileUtils;
import java.io.File;
/* loaded from: classes11.dex */
public class DownloadRequest {
    private CharSequence mDescription;
    private File mFolder;
    private CharSequence mName;
    private String mUri;

    private DownloadRequest() {
    }

    private DownloadRequest(String str, File file, CharSequence charSequence, CharSequence charSequence2) {
        this.mUri = str;
        this.mFolder = file;
        this.mName = charSequence;
        this.mDescription = charSequence2;
    }

    public String getUri() {
        return this.mUri;
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

    public CharSequence getDescription() {
        return this.mDescription;
    }

    /* loaded from: classes11.dex */
    public static class Builder {
        private CharSequence mDescription;
        private File mFolder;
        private CharSequence mName;
        private String mUri;

        public Builder setUri(String str) {
            this.mUri = str;
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

        public Builder setDescription(CharSequence charSequence) {
            this.mDescription = charSequence;
            return this;
        }

        public DownloadRequest build() {
            return new DownloadRequest(this.mUri, this.mFolder, this.mName, this.mDescription);
        }
    }
}
