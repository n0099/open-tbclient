package com.baidu.cyberplayer.sdk.extractor;

import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends ExtractorProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaExtractor a;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new MediaExtractor();
    }

    private Integer a(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            MediaExtractor mediaExtractor = this.a;
            if (mediaExtractor != null && Build.VERSION.SDK_INT >= 16) {
                int trackCount = mediaExtractor.getTrackCount();
                for (int i = 0; i < trackCount; i++) {
                    if (this.a.getTrackFormat(i).getString("mime").startsWith(str)) {
                        num = Integer.valueOf(i);
                        break;
                    }
                }
            }
            num = null;
            return Integer.valueOf(num != null ? num.intValue() : -1);
        }
        return (Integer) invokeL.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public Bundle getMediaMeta() {
        InterceptResult invokeV;
        MediaFormat trackFormat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bundle bundle = new Bundle();
            if (this.a != null) {
                int intValue = a(FileUtils.VIDEO_FILE_START).intValue();
                int intValue2 = a("audio/").intValue();
                if (intValue != -1) {
                    intValue2 = intValue;
                }
                if (intValue2 != -1 && (trackFormat = this.a.getTrackFormat(intValue2)) != null) {
                    try {
                        bundle.putLong("duration", trackFormat.getLong("durationUs") / 1000);
                        if (intValue != -1) {
                            bundle.putInt("width", trackFormat.getInteger("width"));
                            bundle.putInt("height", trackFormat.getInteger("height"));
                        }
                    } catch (Exception e) {
                        CyberLog.e("MediaExtractorImpl", "getMediaMeta Exception");
                        e.printStackTrace();
                    }
                }
            }
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            CyberLog.i("MediaExtractorImpl", "release");
            MediaExtractor mediaExtractor = this.a;
            if (mediaExtractor != null) {
                mediaExtractor.release();
                this.a = null;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(Context context, Uri uri) {
        MediaExtractor mediaExtractor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, uri) == null) || (mediaExtractor = this.a) == null) {
            return;
        }
        try {
            mediaExtractor.setDataSource(context, uri, (Map<String, String>) null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        MediaExtractor mediaExtractor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, context, uri, map) == null) || (mediaExtractor = this.a) == null) {
            return;
        }
        try {
            mediaExtractor.setDataSource(context, uri, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        MediaExtractor mediaExtractor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, fileDescriptor) == null) || (mediaExtractor = this.a) == null) {
            return;
        }
        try {
            mediaExtractor.setDataSource(fileDescriptor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(String str) {
        MediaExtractor mediaExtractor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (mediaExtractor = this.a) == null) {
            return;
        }
        try {
            mediaExtractor.setDataSource(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
