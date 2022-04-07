package com.baidu.sofire.ac;
/* loaded from: classes2.dex */
public interface IVideoRecordProcess {
    int cancelRecord();

    void prepare();

    int release();

    int startRecord();

    int stopRecord();
}
