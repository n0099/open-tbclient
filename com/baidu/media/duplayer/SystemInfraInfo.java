package com.baidu.media.duplayer;

import com.baidu.cyberplayer.sdk.CyberLog;
/* loaded from: classes18.dex */
public class SystemInfraInfo {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2256a = false;
    @Keep
    private long mBuildDateUTC;
    @Keep
    private long mMaxCpuFreq;
    @Keep
    private long mNumProcessors;
    @Keep
    private long mPmSizeAvailable;
    @Keep
    private long mVmMaxSlice;
    @Keep
    private long mVmPeak;
    @Keep
    private long mVmSize;
    @Keep
    private long mVmSizeAvailable;
    @Keep
    private long mVmSizeInSmaps;

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

    private void i() {
        if (this.f2256a) {
            return;
        }
        nativeGetConstInfo();
        CyberLog.i("", "SystemInfraInfo mNumProcessors:" + this.mNumProcessors + " \nmMaxCpuFreq:" + this.mMaxCpuFreq + " \nmBuildDateUTC" + this.mBuildDateUTC);
        this.f2256a = true;
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
}
