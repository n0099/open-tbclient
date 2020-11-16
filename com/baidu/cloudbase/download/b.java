package com.baidu.cloudbase.download;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes16.dex */
public class b {
    public CharSequence mDescription;
    public File mFolder;
    public CharSequence mName;
    public String mUri;

    /* loaded from: classes16.dex */
    public static class a {
        public CharSequence mDescription;
        public File mFolder;
        public CharSequence mName;
        public String mUri;

        public a d(CharSequence charSequence) {
            this.mName = charSequence;
            return this;
        }

        public a dv(String str) {
            this.mUri = str;
            return this;
        }

        public a k(File file) {
            this.mFolder = file;
            return this;
        }

        public b uF() {
            return new b(this.mUri, this.mFolder, this.mName, this.mDescription);
        }
    }

    public b() {
    }

    public b(String str, File file, CharSequence charSequence, CharSequence charSequence2) {
        this.mUri = str;
        this.mFolder = file;
        this.mName = charSequence;
        this.mDescription = charSequence2;
    }

    public File getFolder() {
        return this.mFolder;
    }

    public CharSequence getName() {
        if (TextUtils.isEmpty(this.mName)) {
            this.mName = com.baidu.cloudbase.download.b.b.getFileFullName(getUri());
        }
        return this.mName;
    }

    public String getUri() {
        return this.mUri;
    }
}
