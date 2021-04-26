package com.baidu.cyberplayer.sdk.extractor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.cyberplayer.sdk.Keep;
import java.io.FileDescriptor;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public abstract class ExtractorProvider {
    public abstract Bundle getMediaMeta();

    public abstract void release();

    public abstract void setDataSource(Context context, Uri uri);

    public abstract void setDataSource(Context context, Uri uri, Map<String, String> map);

    public abstract void setDataSource(FileDescriptor fileDescriptor);

    public abstract void setDataSource(String str);

    public void setOption(int i2, String str, long j) {
    }
}
