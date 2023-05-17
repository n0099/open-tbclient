package com.baidu.searchbox.live.model.res;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u0001:\u0002\b\tB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/live/model/res/MixResult;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "toString", "()Ljava/lang/String;", "<init>", "()V", "MixError", "MixSuccess", "Lcom/baidu/searchbox/live/model/res/MixResult$MixSuccess;", "Lcom/baidu/searchbox/live/model/res/MixResult$MixError;", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public abstract class MixResult<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u0000*\n\b\u0001\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003B+\u0012\n\u0010\r\u001a\u00060\u0004j\u0002`\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b!\u0010\"J\u0014\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00018\u0001HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ<\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\f\b\u0002\u0010\r\u001a\u00060\u0004j\u0002`\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00018\u0001HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\u000f\u001a\u0004\u0018\u00018\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\fR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u001d\u0010\r\u001a\u00060\u0004j\u0002`\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\u0007¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/live/model/res/MixResult$MixError;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/baidu/searchbox/live/model/res/MixResult;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "component1", "()Ljava/lang/Exception;", "", "component2", "()Ljava/lang/Integer;", "component3", "()Ljava/lang/Object;", "exception", "errorno", "data", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/Exception;Ljava/lang/Integer;Ljava/lang/Object;)Lcom/baidu/searchbox/live/model/res/MixResult$MixError;", "other", "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getData", "Ljava/lang/Integer;", "getErrorno", "Ljava/lang/Exception;", "getException", "<init>", "(Ljava/lang/Exception;Ljava/lang/Integer;Ljava/lang/Object;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class MixError<T> extends MixResult<T> {
        public final T data;
        public final Integer errorno;
        public final Exception exception;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.live.model.res.MixResult$MixError */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MixError copy$default(MixError mixError, Exception exc, Integer num, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                exc = mixError.exception;
            }
            if ((i & 2) != 0) {
                num = mixError.errorno;
            }
            if ((i & 4) != 0) {
                obj = mixError.data;
            }
            return mixError.copy(exc, num, obj);
        }

        public final Exception component1() {
            return this.exception;
        }

        public final Integer component2() {
            return this.errorno;
        }

        public final T component3() {
            return this.data;
        }

        public final MixError<T> copy(Exception exc, Integer num, T t) {
            return new MixError<>(exc, num, t);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof MixError) {
                    MixError mixError = (MixError) obj;
                    return Intrinsics.areEqual(this.exception, mixError.exception) && Intrinsics.areEqual(this.errorno, mixError.errorno) && Intrinsics.areEqual(this.data, mixError.data);
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            Exception exc = this.exception;
            int hashCode = (exc != null ? exc.hashCode() : 0) * 31;
            Integer num = this.errorno;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
            T t = this.data;
            return hashCode2 + (t != null ? t.hashCode() : 0);
        }

        @Override // com.baidu.searchbox.live.model.res.MixResult
        public String toString() {
            return "MixError(exception=" + this.exception + ", errorno=" + this.errorno + ", data=" + this.data + SmallTailInfo.EMOTION_SUFFIX;
        }

        public MixError(Exception exc, Integer num, T t) {
            super(null);
            this.exception = exc;
            this.errorno = num;
            this.data = t;
        }

        public /* synthetic */ MixError(Exception exc, Integer num, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(exc, (i & 2) != 0 ? -1 : num, (i & 4) != 0 ? null : obj);
        }

        public final T getData() {
            return this.data;
        }

        public final Integer getErrorno() {
            return this.errorno;
        }

        public final Exception getException() {
            return this.exception;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u0000*\n\b\u0001\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003B\u001d\b\u0007\u0012\u0006\u0010\t\u001a\u00028\u0001\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0004\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\t\u001a\u00028\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/live/model/res/MixResult$MixSuccess;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/baidu/searchbox/live/model/res/MixResult;", "component1", "()Ljava/lang/Object;", "Lcom/baidu/searchbox/live/model/res/MixResultStatData;", "component2", "()Lcom/baidu/searchbox/live/model/res/MixResultStatData;", "data", "statData", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/Object;Lcom/baidu/searchbox/live/model/res/MixResultStatData;)Lcom/baidu/searchbox/live/model/res/MixResult$MixSuccess;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getData", "Lcom/baidu/searchbox/live/model/res/MixResultStatData;", "getStatData", "<init>", "(Ljava/lang/Object;Lcom/baidu/searchbox/live/model/res/MixResultStatData;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class MixSuccess<T> extends MixResult<T> {
        public final T data;
        public final MixResultStatData statData;

        @JvmOverloads
        public MixSuccess(T t) {
            this(t, null, 2, null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.live.model.res.MixResult$MixSuccess */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MixSuccess copy$default(MixSuccess mixSuccess, Object obj, MixResultStatData mixResultStatData, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = mixSuccess.data;
            }
            if ((i & 2) != 0) {
                mixResultStatData = mixSuccess.statData;
            }
            return mixSuccess.copy(obj, mixResultStatData);
        }

        public final T component1() {
            return this.data;
        }

        public final MixResultStatData component2() {
            return this.statData;
        }

        public final MixSuccess<T> copy(T t, MixResultStatData mixResultStatData) {
            return new MixSuccess<>(t, mixResultStatData);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof MixSuccess) {
                    MixSuccess mixSuccess = (MixSuccess) obj;
                    return Intrinsics.areEqual(this.data, mixSuccess.data) && Intrinsics.areEqual(this.statData, mixSuccess.statData);
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            T t = this.data;
            int hashCode = (t != null ? t.hashCode() : 0) * 31;
            MixResultStatData mixResultStatData = this.statData;
            return hashCode + (mixResultStatData != null ? mixResultStatData.hashCode() : 0);
        }

        @Override // com.baidu.searchbox.live.model.res.MixResult
        public String toString() {
            return "MixSuccess(data=" + this.data + ", statData=" + this.statData + SmallTailInfo.EMOTION_SUFFIX;
        }

        @JvmOverloads
        public MixSuccess(T t, MixResultStatData mixResultStatData) {
            super(null);
            this.data = t;
            this.statData = mixResultStatData;
        }

        public /* synthetic */ MixSuccess(Object obj, MixResultStatData mixResultStatData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i & 2) != 0 ? null : mixResultStatData);
        }

        public final T getData() {
            return this.data;
        }

        public final MixResultStatData getStatData() {
            return this.statData;
        }
    }

    public MixResult() {
    }

    public /* synthetic */ MixResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public String toString() {
        if (this instanceof MixSuccess) {
            return "Success[data=" + ((MixSuccess) this).getData() + ']';
        } else if (this instanceof MixError) {
            return "Error[exception=" + ((MixError) this).getException() + ']';
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
