package com.android.support.appcompat.storage;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import java.util.Arrays;
/* loaded from: classes15.dex */
public class b {
    public Bundle HA;
    public String HB;
    public CancellationSignal HC;
    public a HD;
    public String Hz;
    public String mimeType;
    public String[] selectionArgs;
    public long timeStamp;
    public Uri uri;
    public ContentValues values;

    public String toString() {
        return "RequestInfo{uri=" + this.uri + ", fileOpenMode='" + this.Hz + "', mimeType='" + this.mimeType + "', opts=" + this.HA + ", where='" + this.HB + "', selectionArgs=" + Arrays.toString(this.selectionArgs) + ", values=" + this.values + ", cancellationSignal=" + this.HC + ", requestCallback=" + this.HD + ", timeStamp=" + this.timeStamp + '}';
    }
}
