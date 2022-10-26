package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Media;
/* loaded from: classes3.dex */
public class MediaData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EXT_TYPE_XIAOYING = 12;
    public transient /* synthetic */ FieldHolder $fh;
    public int during_time;
    public int e_type;
    public boolean isLongPic;
    public String origin_pic;
    public long original_size;
    public String original_url;
    public int picHeight;
    public int picWidth;
    public String pic_url;
    public long postId;
    public boolean showOriginBtn;
    public String small_pic_url;
    public double smartCropCenterPointHeightRatio;
    public double smartCropCenterPointWidthRatio;
    public String src_pic;
    public String thumbnails_url;
    public int type;
    public String video_url;

    public MediaData() {
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
        this.e_type = -1;
        this.postId = -1L;
        this.picWidth = 0;
        this.picHeight = 0;
        this.type = -1;
        this.pic_url = null;
        this.video_url = null;
        this.src_pic = null;
        this.original_url = null;
        this.original_size = 0L;
        this.postId = -1L;
        this.thumbnails_url = null;
        this.during_time = 0;
        this.isLongPic = false;
        this.showOriginBtn = false;
        this.smartCropCenterPointWidthRatio = 0.0d;
        this.smartCropCenterPointHeightRatio = 0.0d;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.during_time;
        }
        return invokeV.intValue;
    }

    public long getOriginalSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.original_size;
        }
        return invokeV.longValue;
    }

    public String getOriginalUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.original_url;
        }
        return (String) invokeV.objValue;
    }

    public String getPicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.pic_url;
        }
        return (String) invokeV.objValue;
    }

    public long getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.postId;
        }
        return invokeV.longValue;
    }

    public String getSmallPicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.small_pic_url;
        }
        return (String) invokeV.objValue;
    }

    public String getSmallUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.pic_url;
        }
        return (String) invokeV.objValue;
    }

    public double getSmartCropCenterPointHeightRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.smartCropCenterPointHeightRatio;
        }
        return invokeV.doubleValue;
    }

    public double getSmartCropCenterPointWidthRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.smartCropCenterPointWidthRatio;
        }
        return invokeV.doubleValue;
    }

    public String getSrc_pic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.src_pic;
        }
        return (String) invokeV.objValue;
    }

    public String getThumbnails_url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.thumbnails_url;
        }
        return (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.video_url;
        }
        return (String) invokeV.objValue;
    }

    public boolean isLongPic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.isLongPic;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowOriginBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.showOriginBtn;
        }
        return invokeV.booleanValue;
    }

    public boolean isSmartCrop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.smartCropCenterPointWidthRatio > 0.0d && this.smartCropCenterPointHeightRatio > 0.0d) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isXiaoying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.type == 5 && this.e_type == 12) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("type");
            this.type = optInt;
            if (optInt == 3) {
                this.pic_url = jSONObject.optString("big_pic");
                this.src_pic = jSONObject.optString("src_pic");
            } else if (optInt == 5) {
                this.pic_url = jSONObject.optString("vpic");
                this.video_url = jSONObject.optString("vsrc");
            }
            this.original_url = jSONObject.optString("original_url");
            this.original_size = jSONObject.optLong("original_size");
            this.postId = jSONObject.optLong("post_id");
            this.during_time = jSONObject.optInt("during_time");
            boolean z2 = true;
            if (jSONObject.optInt("is_long_pic", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.isLongPic = z;
            if (jSONObject.optInt("show_original_btn", 1) != 1) {
                z2 = false;
            }
            this.showOriginBtn = z2;
            this.small_pic_url = jSONObject.optString("small_pic");
            this.origin_pic = jSONObject.optString("origin_pic");
            this.smartCropCenterPointWidthRatio = jSONObject.optDouble("wth_mid_loc");
            this.smartCropCenterPointHeightRatio = jSONObject.optDouble("hth_mid_loc");
            this.picWidth = jSONObject.optInt("width", 0);
            this.picHeight = jSONObject.optInt("height", 0);
            if (TextUtils.isEmpty(this.src_pic)) {
                if (!TextUtils.isEmpty(this.original_url)) {
                    this.src_pic = this.original_url;
                } else if (!TextUtils.isEmpty(this.pic_url)) {
                    this.src_pic = this.pic_url;
                    this.original_url = this.pic_url;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void parserProtobuf(Media media) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, media) != null) || media == null) {
            return;
        }
        int intValue = media.type.intValue();
        this.type = intValue;
        if (intValue == 3) {
            this.pic_url = media.big_pic;
            this.src_pic = media.src_pic;
        } else if (intValue == 5) {
            this.pic_url = media.vpic;
            this.video_url = media.vsrc;
            this.e_type = media.e_type.intValue();
        }
        this.during_time = media.during_time.intValue();
        this.thumbnails_url = media.dynamic_pic;
        this.original_url = media.origin_pic;
        this.original_size = media.origin_size.intValue();
        this.postId = media.post_id.longValue();
        boolean z2 = false;
        if (media.is_long_pic.intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isLongPic = z;
        if (media.show_original_btn.intValue() == 1) {
            z2 = true;
        }
        this.showOriginBtn = z2;
        this.small_pic_url = media.small_pic;
        this.origin_pic = media.origin_pic;
        this.smartCropCenterPointWidthRatio = media.wth_mid_loc.doubleValue();
        this.smartCropCenterPointHeightRatio = media.hth_mid_loc.doubleValue();
        this.picWidth = media.width.intValue();
        this.picHeight = media.height.intValue();
        if (TextUtils.isEmpty(this.src_pic)) {
            if (!TextUtils.isEmpty(this.original_url)) {
                this.src_pic = this.original_url;
            } else if (!TextUtils.isEmpty(this.pic_url)) {
                String str = this.pic_url;
                this.src_pic = str;
                this.original_url = str;
                if (TextUtils.isEmpty(this.origin_pic)) {
                    this.origin_pic = this.pic_url;
                }
                if (TextUtils.isEmpty(this.thumbnails_url)) {
                    this.thumbnails_url = this.pic_url;
                }
            }
        }
    }

    public void setDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.during_time = i;
        }
    }

    public void setIsLongPic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.isLongPic = z;
        }
    }

    public void setOriginalSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.original_size = j;
        }
    }

    public void setOriginalUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.original_url = str;
        }
    }

    public void setPic(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.pic_url = str;
        }
    }

    public void setSrc_pic(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.src_pic = str;
        }
    }

    public void setThumbnails_url(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.thumbnails_url = str;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.type = i;
        }
    }

    public void setVideo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.video_url = str;
        }
    }
}
