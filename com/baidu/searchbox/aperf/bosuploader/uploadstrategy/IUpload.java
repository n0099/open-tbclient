package com.baidu.searchbox.aperf.bosuploader.uploadstrategy;

import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public interface IUpload {
    void upload();

    void upload(List<File> list, String str, String str2);
}
