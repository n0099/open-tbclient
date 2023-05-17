package com.baidu.sofire.face.api;
/* loaded from: classes4.dex */
public interface IVideoRecordProcess {
    int cancelRecord();

    void prepare();

    int release();

    int startRecord();

    int stopRecord();
}
