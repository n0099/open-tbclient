package com.baidu.tbadk.album;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class VideoFileInfo extends MediaFileInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 4168698601975684150L;
    public transient /* synthetic */ FieldHolder $fh;
    public int albumId;
    public String albumName;
    public long beginTime;
    public String contentUriStr;
    public String displayName;
    public String durationText;
    public long fileSize;
    public boolean hasLoaded;
    public long lastModified;
    public String mimeType;
    public String thumbPath;
    public Bitmap thumbnailBitmap;
    public String title;
    public int videoDuration;
    public int videoHeight;
    public int videoId;
    public String videoMd5;
    public String videoPath;
    public int videoWidth;

    public VideoFileInfo() {
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
        this.hasLoaded = false;
    }

    @Override // com.baidu.tbadk.album.MediaFileInfo
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }
}
