package com.android.support.appcompat.storage;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class b {
    public String Hj;
    public Bundle Hk;
    public String Hl;
    public CancellationSignal Hm;
    public a Hn;
    public String mimeType;
    public String[] selectionArgs;
    public long timeStamp;
    public Uri uri;
    public ContentValues values;

    public String toString() {
        return "RequestInfo{uri=" + this.uri + ", fileOpenMode='" + this.Hj + "', mimeType='" + this.mimeType + "', opts=" + this.Hk + ", where='" + this.Hl + "', selectionArgs=" + Arrays.toString(this.selectionArgs) + ", values=" + this.values + ", cancellationSignal=" + this.Hm + ", requestCallback=" + this.Hn + ", timeStamp=" + this.timeStamp + '}';
    }
}
