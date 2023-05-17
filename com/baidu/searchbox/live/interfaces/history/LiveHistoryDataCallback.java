package com.baidu.searchbox.live.interfaces.history;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/history/LiveHistoryDataCallback;", ExifInterface.GPS_DIRECTION_TRUE, "result", "", "onResult", "(Ljava/lang/Object;)V", "", "onUIBack", "()Z", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public abstract class LiveHistoryDataCallback<T> {
    public abstract void onResult(T t);

    public boolean onUIBack() {
        return true;
    }
}
