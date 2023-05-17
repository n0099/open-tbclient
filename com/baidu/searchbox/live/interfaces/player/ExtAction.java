package com.baidu.searchbox.live.interfaces.player;

import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000B\u0013\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0013\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/ExtAction;", ExifInterface.GPS_DIRECTION_TRUE, "", "k", "def", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "(ILjava/lang/Object;)Ljava/lang/Object;", "", "v", "", "put", "(ILjava/lang/Object;)V", "", "action", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "desc", "Ljava/lang/StringBuilder;", "Landroid/util/SparseArray;", "eventBundle", "Landroid/util/SparseArray;", "logLevel", "I", "priority", "targetType", "type", "<init>", "(Ljava/lang/String;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class ExtAction {
    public final String action;
    public final StringBuilder desc;
    public SparseArray<Object> eventBundle;
    public int logLevel;
    public int priority;
    public int targetType;
    public int type;

    public ExtAction() {
        this(null, 1, null);
    }

    public ExtAction(String str) {
        this.action = str;
        this.eventBundle = new SparseArray<>(3);
        this.type = -1;
        this.targetType = -1;
        this.priority = 0;
        this.logLevel = 0;
    }

    public /* synthetic */ ExtAction(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final <T> T get(int i, T t) {
        Object obj;
        SparseArray<Object> sparseArray = this.eventBundle;
        Object obj2 = null;
        if (sparseArray != null) {
            obj = sparseArray.get(i);
        } else {
            obj = null;
        }
        if (obj instanceof Object) {
            obj2 = obj;
        }
        if (obj2 != null) {
            return (T) obj2;
        }
        return t;
    }

    public final void put(int i, Object obj) {
        SparseArray<Object> sparseArray = this.eventBundle;
        if (sparseArray != null) {
            sparseArray.put(i, obj);
        }
    }

    public final String getAction() {
        return this.action;
    }
}
