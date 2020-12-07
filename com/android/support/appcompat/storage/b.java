package com.android.support.appcompat.storage;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import java.util.Arrays;
/* loaded from: classes10.dex */
public class b {
    public String It;
    public Bundle Iu;
    public String Iv;
    public CancellationSignal Iw;
    public a Ix;
    public String mimeType;
    public String[] selectionArgs;
    public long timeStamp;
    public Uri uri;
    public ContentValues values;

    public String toString() {
        return "RequestInfo{uri=" + this.uri + ", fileOpenMode='" + this.It + "', mimeType='" + this.mimeType + "', opts=" + this.Iu + ", where='" + this.Iv + "', selectionArgs=" + Arrays.toString(this.selectionArgs) + ", values=" + this.values + ", cancellationSignal=" + this.Iw + ", requestCallback=" + this.Ix + ", timeStamp=" + this.timeStamp + '}';
    }
}
