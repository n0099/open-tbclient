package com.baidu.searchbox.ng.ai.apps.trace;

import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class ErrCode implements ErrDef {
    private ErrCode mCauseBy = null;
    private long mFeature = 0;
    private long mError = 0;
    private long mPlatform = 2;
    private String mDesc = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean mHasRecorded = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(code()), Long.valueOf(platform()), Long.valueOf(feature()), Long.valueOf(error()), desc()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(platform()), Long.valueOf(feature()), Long.valueOf(error())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", details()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public ErrCode platform(long j) {
        this.mPlatform = illegalFallback(j, 9L, "platform");
        return this;
    }

    public long platform() {
        return this.mPlatform;
    }

    public ErrCode feature(long j) {
        this.mFeature = illegalFallback(j, 999L, "feature");
        return this;
    }

    public long feature() {
        return this.mFeature;
    }

    public ErrCode error(long j) {
        this.mError = illegalFallback(j, 9999L, AiAppsTouchHelper.TouchEventName.TOUCH_ERROR);
        return this;
    }

    public long error() {
        return this.mError;
    }

    public ErrCode desc(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String desc() {
        return this.mDesc;
    }

    public ErrCode detail(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder details() {
        return this.mDetails;
    }

    public ErrCode causeBy(ErrCode errCode) {
        this.mCauseBy = errCode;
        return this;
    }

    public ErrCode causeBy() {
        return this.mCauseBy;
    }

    public long code() {
        return (platform() * ErrDef.Platform.WEIGHT) + (feature() * ErrDef.Feature.WEIGHT) + (error() * 1);
    }

    public ErrCode code(long j) {
        platform(j / ErrDef.Platform.WEIGHT);
        long j2 = j % ErrDef.Platform.WEIGHT;
        feature(j2 / ErrDef.Feature.WEIGHT);
        error((j2 % ErrDef.Feature.WEIGHT) / 1);
        return this;
    }

    public boolean hasRecorded() {
        return this.mHasRecorded;
    }

    public void markRecorded() {
        this.mHasRecorded = true;
    }

    private long illegalFallback(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            detail("illegalFallback " + str + "::" + String.valueOf(j));
        }
        return z ? j2 : j;
    }
}
