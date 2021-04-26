package com.baidu.media.duplayer;

import com.baidu.cyberplayer.sdk.CyberLog;
/* loaded from: classes2.dex */
public class SystemInfraInfo {

    /* renamed from: a  reason: collision with root package name */
    public boolean f8279a = false;
    @Keep
    public long mBuildDateUTC;
    @Keep
    public long mMaxCpuFreq;
    @Keep
    public long mNumProcessors;
    @Keep
    public long mPmSizeAvailable;
    @Keep
    public long mVmMaxSlice;
    @Keep
    public long mVmPeak;
    @Keep
    public long mVmSize;
    @Keep
    public long mVmSizeAvailable;
    @Keep
    public long mVmSizeInSmaps;

    public SystemInfraInfo() {
        this.mVmSize = 0L;
        this.mVmPeak = 0L;
        this.mVmSizeInSmaps = 0L;
        this.mVmSizeAvailable = 0L;
        this.mVmMaxSlice = 0L;
        this.mNumProcessors = 0L;
        this.mMaxCpuFreq = 0L;
        this.mBuildDateUTC = 0L;
        this.mPmSizeAvailable = 0L;
        this.mVmSize = -1L;
        this.mVmPeak = -1L;
        this.mVmSizeInSmaps = -1L;
        this.mVmSizeAvailable = -1L;
        this.mVmMaxSlice = -1L;
        this.mNumProcessors = -1L;
        this.mMaxCpuFreq = -1L;
        this.mBuildDateUTC = -1L;
        this.mPmSizeAvailable = -1L;
    }

    private native void nativeGetConstInfo();

    private native void nativeGetCurrentInfoVm();

    private native void nativeGetCurrentInfoVmInSmaps();

    private native void nativeGetCurrentMemInfo();

    public void a() {
        nativeGetCurrentInfoVm();
        CyberLog.i("", "SystemInfraInfo mVmSize:" + this.mVmSize + " mVmPeak:" + this.mVmPeak);
    }

    public void b() {
        nativeGetCurrentMemInfo();
        CyberLog.i("", "SystemInfraInfo mPmSizeAvailable:" + this.mPmSizeAvailable);
    }

    public long c() {
        return this.mVmSize;
    }

    public long d() {
        return this.mVmPeak;
    }

    public long e() {
        i();
        return this.mNumProcessors;
    }

    public long f() {
        i();
        return this.mMaxCpuFreq;
    }

    public long g() {
        i();
        return this.mBuildDateUTC;
    }

    public long h() {
        return this.mPmSizeAvailable;
    }

    public final void i() {
        if (this.f8279a) {
            return;
        }
        nativeGetConstInfo();
        CyberLog.i("", "SystemInfraInfo mNumProcessors:" + this.mNumProcessors + " \nmMaxCpuFreq:" + this.mMaxCpuFreq + " \nmBuildDateUTC" + this.mBuildDateUTC);
        this.f8279a = true;
    }
}
