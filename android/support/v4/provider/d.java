package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
/* loaded from: classes2.dex */
class d extends DocumentFile {
    private Context mContext;
    private Uri mUri;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.mContext = context;
        this.mUri = uri;
    }

    @Override // android.support.v4.provider.DocumentFile
    public DocumentFile createFile(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.provider.DocumentFile
    public DocumentFile createDirectory(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.provider.DocumentFile
    public Uri getUri() {
        return this.mUri;
    }

    @Override // android.support.v4.provider.DocumentFile
    public String getName() {
        return a.b(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public String getType() {
        return a.d(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean isDirectory() {
        return a.e(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean isFile() {
        return a.f(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public long lastModified() {
        return a.g(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public long length() {
        return a.h(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean canRead() {
        return a.i(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean canWrite() {
        return a.j(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean delete() {
        return a.k(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean exists() {
        return a.l(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public DocumentFile[] listFiles() {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean renameTo(String str) {
        throw new UnsupportedOperationException();
    }
}
